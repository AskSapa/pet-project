package kg.mycloud.pocker.dtos;

import java.math.BigDecimal;

public record TournamentPlayerResponse(String playerId, PlayerResponse player, Integer rebuys, Integer addons,
                                       Boolean isOut, Integer outPosition, BigDecimal prize) {
}
