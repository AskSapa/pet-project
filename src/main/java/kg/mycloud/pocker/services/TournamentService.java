package kg.mycloud.pocker.services;

import kg.mycloud.pocker.dtos.CreateTournamentInput;
import kg.mycloud.pocker.dtos.TournamentResponse;

public interface TournamentService {
    TournamentResponse create(CreateTournamentInput input);
    TournamentResponse getCurrentTournament();
}
