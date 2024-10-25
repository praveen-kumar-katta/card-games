package org.example.cardgames.repository.stores.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cardgames.repository.GameSessionRepository;
import org.example.cardgames.repository.mappers.GameSessionEntityMapper;
import org.example.cardgames.repository.stores.GameSessionStore;
import org.example.cardgames.service.models.GameSession;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameSessionStoreImpl implements GameSessionStore {

  private final GameSessionRepository gameSessionRepository;

  @Override
  public List<GameSession> getGameSessionsByGameId(String gameId) {
    return GameSessionEntityMapper.INSTANCE.toService(
        gameSessionRepository.findAllByGameId(gameId));
  }

  @Override
  public List<GameSession> save(List<GameSession> gameSessions) {
    return GameSessionEntityMapper.INSTANCE.toService(
        gameSessionRepository.saveAll(GameSessionEntityMapper.INSTANCE.toRepository(gameSessions)));
  }
}
