package kg.mycloud.pocker.dtos;

import kg.mycloud.pocker.enums.TournamentStatus;

import java.math.BigDecimal;
import java.util.List;

public record TournamentResponse(String id, String name, String date,
                                 TournamentStatus status, TournamentSettingsResponse settings, List<TournamentPlayerResponse> players, BigDecimal prizePool,
                                 PlayerResponse winner, String createdAt, String startedAt, String finishedAt, Integer currentLevel,
                                 Integer levelStartTime, Integer pauseTimeRemaining, Boolean isOnBreak, Integer totalPausedTime) {
}
