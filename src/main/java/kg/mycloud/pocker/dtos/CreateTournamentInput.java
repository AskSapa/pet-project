package kg.mycloud.pocker.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record CreateTournamentInput(
        String name,
        TournamentSettingsResponse settings, List<String> playerIds,
        LocalDateTime date) {
}
