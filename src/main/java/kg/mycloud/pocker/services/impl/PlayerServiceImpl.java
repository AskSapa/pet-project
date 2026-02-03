package kg.mycloud.pocker.services.impl;

import jakarta.transaction.Transactional;
import kg.mycloud.pocker.dtos.CreatePlayerInput;
import kg.mycloud.pocker.dtos.PlayerResponse;
import kg.mycloud.pocker.mappers.PlayerMapper;
import kg.mycloud.pocker.models.Player;
import kg.mycloud.pocker.models.PlayerStats;
import kg.mycloud.pocker.repositories.PlayerRepository;
import kg.mycloud.pocker.services.PlayerService;
import kg.mycloud.pocker.services.PlayerStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerStatsService playerStatsService;
    private final PlayerMapper playerMapper;

    @Override
    public List<PlayerResponse> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return playerMapper.toResponseList(players);
    }

    @Override
    @Transactional
    public PlayerResponse create(CreatePlayerInput input) {
        Player player = Player.builder()
                .name(input.name())
                .avatarColor("#000000")
                .createdAt(LocalDateTime.now())
                .stats(new PlayerStats())
                .build();

        playerRepository.save(player);
        return playerMapper.toResponse(player);
    }

    @Override
    public List<Player> getPlayersByIds(List<String> ids) {
        return playerRepository.findAllByIdIn(ids);
    }

    private Player createPlayer(CreatePlayerInput input) {
        PlayerStats playerStats = PlayerStats.builder()
                .totalPrize(BigDecimal.ZERO)
                .bestPlace(0)
                .cashWinnings(BigDecimal.ZERO)
                .build();



        return Player.builder()
                .name(input.name())
                .avatarColor("#000000")
                .createdAt(LocalDateTime.now())
                .stats(playerStats)
                .build();
    }

}
