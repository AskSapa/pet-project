package kg.mycloud.pocker.controllers;

import kg.mycloud.pocker.dtos.CreateTournamentInput;
import kg.mycloud.pocker.dtos.TournamentResponse;
import kg.mycloud.pocker.services.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @PostMapping
    public TournamentResponse createTournament(@RequestBody CreateTournamentInput input) {
        return tournamentService.create(input);
    }

    @GetMapping("/current")
    public TournamentResponse getCurrentTournament() {
        return tournamentService.getCurrentTournament();
    }
}
