package kg.mycloud.pocker.services;

import kg.mycloud.pocker.dtos.CreatePlayerInput;
import kg.mycloud.pocker.dtos.PlayerResponse;
import kg.mycloud.pocker.models.Player;

import java.util.List;

public interface PlayerService {
    List<PlayerResponse> getAllPlayers();
    PlayerResponse create(CreatePlayerInput input);
    List<Player> getPlayersByIds(List<String> strings);
}
