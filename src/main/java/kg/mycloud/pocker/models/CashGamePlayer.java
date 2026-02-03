package kg.mycloud.pocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cash_game_players")
public class CashGamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cash_game_id")
    private CashGame cashGame;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private BigDecimal buyIn;
    private BigDecimal cashOut;
    private int rebuys;
    private BigDecimal totalInvested;
}