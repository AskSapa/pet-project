package kg.mycloud.pocker.dtos;

import java.math.BigDecimal;
import java.util.List;

public record TournamentSettingsResponse(
        BigDecimal buyIn, BigDecimal rebuyPrice,
        BigDecimal addonPrice, TimerSettings timer,
        List<Double> prizeDistribution) {
}
