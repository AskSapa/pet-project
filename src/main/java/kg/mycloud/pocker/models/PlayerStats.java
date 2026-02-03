package kg.mycloud.pocker.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PlayerStats {
    private int tournamentsPlayed;
    private int wins;
    private BigDecimal totalPrize;
    private int totalRebuys;
    private int totalAddons;
    private Integer bestPlace;
    private int cashGamesPlayed;
    private BigDecimal cashWinnings;
}