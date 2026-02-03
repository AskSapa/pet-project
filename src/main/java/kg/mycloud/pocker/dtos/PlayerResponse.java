package kg.mycloud.pocker.dtos;

import kg.mycloud.pocker.models.PlayerStats;

public record PlayerResponse(String id, String name, String avatarColor, String createdAt, PlayerStats stats) {
}