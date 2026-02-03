package kg.mycloud.pocker.controllers;

import kg.mycloud.pocker.dtos.CreatePlayerInput;
import kg.mycloud.pocker.dtos.PlayerResponse;
import kg.mycloud.pocker.services.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<PlayerResponse> getPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public PlayerResponse createPlayer(@RequestBody CreatePlayerInput input) {
        log.info("[PlayerController.createPlayer] {}", input);
        return playerService.create(input);
    }
}
