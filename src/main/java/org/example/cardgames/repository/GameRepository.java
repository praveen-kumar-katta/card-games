package org.example.cardgames.repository;

import java.util.Optional;
import org.example.cardgames.repository.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, String> {

  Optional<GameEntity> findByGameId(String gameId);

}
