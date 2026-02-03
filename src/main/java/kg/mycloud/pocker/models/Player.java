package kg.mycloud.pocker.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(name = "avatar_color")
    private String avatarColor;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Embedded
    private PlayerStats stats;
}