package kg.mycloud.pocker.models;

import jakarta.persistence.*;
import kg.mycloud.pocker.enums.CashGameStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cash_games")
public class CashGame {
    @Id
    private String id;

    private String name;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private CashGameStatus status;

    @OneToMany(mappedBy = "cashGame", cascade = CascadeType.ALL)
    private List<CashGamePlayer> players;

    private BigDecimal smallBlind;
    private BigDecimal bigBlind;
    private BigDecimal minBuyIn;

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
}