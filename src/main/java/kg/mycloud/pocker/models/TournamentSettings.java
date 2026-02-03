package kg.mycloud.pocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournament_settings")
public class TournamentSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal buyIn;
    private BigDecimal rebuyPrice;
    private BigDecimal addonPrice;

    private String prizeDistribution;

    @OneToMany(mappedBy = "settings", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlindLevel> levels;

    private int breakAfterLevels;
    private int breakDuration;
}
