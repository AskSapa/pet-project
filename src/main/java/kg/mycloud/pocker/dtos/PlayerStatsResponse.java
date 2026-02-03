package kg.mycloud.pocker.dtos;

import java.math.BigDecimal;

public record PlayerStatsResponse(Integer tournamentPlayed, Integer wins,
                                  BigDecimal totalPrize, BigDecimal totalRebuys, BigDecimal totalAddons,
                                  Integer bestPlace, Integer cashGamesPlayed, Integer cashWinnings) {
}
