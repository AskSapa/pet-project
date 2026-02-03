package kg.mycloud.pocker.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blind_levels")
public class BlindLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int smallBlind;
    private int bigBlind;
    private Integer ante;
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "settings_id")
    @ToString.Exclude
    private TournamentSettings settings;

    @Column(name = "level_order")
    private int levelOrder;
}
