package org.example.cardgames.repository;

import java.util.List;
import org.example.cardgames.repository.entities.GameSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSessionRepository extends JpaRepository<GameSessionEntity, Long> {

  List<GameSessionEntity> findAllByGameId(String gameId);

}
