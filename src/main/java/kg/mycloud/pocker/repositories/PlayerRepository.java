package kg.mycloud.pocker.repositories;

import kg.mycloud.pocker.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    List<Player> findAllByIdIn(List<String> ids);
}

