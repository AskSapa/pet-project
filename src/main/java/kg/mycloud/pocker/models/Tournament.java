package kg.mycloud.pocker.models;

import jakarta.persistence.*;
import kg.mycloud.pocker.enums.TournamentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private TournamentStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "settings_id")
    private TournamentSettings settings;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private List<TournamentPlayer> players;

    private BigDecimal prizePool;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    private LocalDateTime createdAt;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private int currentLevel;
    private Long levelStartTime;
    private Long pausedTimeRemaining;
    private boolean isOnBreak;
    private long totalPausedTime;
}
