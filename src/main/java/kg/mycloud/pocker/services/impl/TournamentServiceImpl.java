package kg.mycloud.pocker.services.impl;

import kg.mycloud.pocker.dtos.BlindLevelDto;
import kg.mycloud.pocker.dtos.CreateTournamentInput;
import kg.mycloud.pocker.dtos.TournamentResponse;
import kg.mycloud.pocker.enums.TournamentStatus;
import kg.mycloud.pocker.mappers.TournamentMapper;
import kg.mycloud.pocker.models.*;
import kg.mycloud.pocker.repositories.TournamentRepository;
import kg.mycloud.pocker.services.PlayerService;
import kg.mycloud.pocker.services.TournamentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;
    private final PlayerService playerService;

    @Override
    @Transactional
    public TournamentResponse create(CreateTournamentInput input) {
        log.info("Tournament create request received.");
        List<Player> players = playerService.getPlayersByIds(input.playerIds());

        TournamentSettings settings = TournamentSettings.builder()
                .buyIn(input.settings().buyIn())
                .rebuyPrice(input.settings().rebuyPrice())
                .addonPrice(input.settings().addonPrice())
                .prizeDistribution(String.join(",", input.settings().prizeDistribution().stream().map(String::valueOf).toList()))
                .breakAfterLevels(input.settings().timer().breakAfterLevels())
                .breakDuration(input.settings().timer().breakDuration())
                .build();

        if (input.settings().timer().levels() != null) {
            List<BlindLevelDto> levelInputs = input.settings().timer().levels();
            List<BlindLevel> levels = new ArrayList<>();

            for (int i = 0; i < levelInputs.size(); i++) {
                BlindLevelDto l = levelInputs.get(i);
                levels.add(BlindLevel.builder()
                        .smallBlind(l.smallBlind())
                        .bigBlind(l.bigBlind())
                        .ante(l.ante())
                        .duration(l.duration())
                        .levelOrder(i + 1)
                        .settings(settings)
                        .build());
            }
            settings.setLevels(levels);
        }
        Tournament tournament = Tournament.builder()
                .name(input.name())
                .date(input.date())
                .status(TournamentStatus.SETUP)
                .settings(settings)
                .createdAt(LocalDateTime.now())
                .prizePool(input.settings().buyIn().multiply(BigDecimal.valueOf(players.size())))
                .currentLevel(0)
                .isOnBreak(false)
                .totalPausedTime(0L)
                .build();

        List<TournamentPlayer> tournamentPlayers = players.stream()
                .map(player -> TournamentPlayer.builder()
                        .tournament(tournament)
                        .player(player)
                        .rebuys(0)
                        .addons(0)
                        .isOut(false)
                        .prize(BigDecimal.ZERO)
                        .build())
                .toList();

        tournament.setPlayers(tournamentPlayers);

        Tournament savedTournament = tournamentRepository.save(tournament);

        return tournamentMapper.toResponse(savedTournament);
    }

    @Override
    public TournamentResponse getCurrentTournament() {
        return tournamentRepository.findFirstByStatusNotOrderByCreatedAtDesc(TournamentStatus.FINISHED)
                .map(tournament -> {
                    log.info("Current tournament found: {} (Status: {})", tournament.getName(), tournament.getStatus());
                    return tournamentMapper.toResponse(tournament);
                })
                .orElseGet(() -> {
                    log.info("No active tournaments found.");
                    return null;
                });
    }
}