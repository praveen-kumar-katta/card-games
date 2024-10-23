package org.example.cardgames.repository;

import org.example.cardgames.repository.entities.GameSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSessionRepository extends JpaRepository<GameSessionEntity, Long> {

}
