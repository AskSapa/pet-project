package kg.mycloud.pocker.repositories;

import kg.mycloud.pocker.enums.TournamentStatus;
import kg.mycloud.pocker.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    Optional<Tournament> findFirstByStatusNotOrderByCreatedAtDesc(TournamentStatus status);
}
