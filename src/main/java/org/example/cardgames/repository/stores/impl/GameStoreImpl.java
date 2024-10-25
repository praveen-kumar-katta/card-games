package org.example.cardgames.repository.stores.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cardgames.repository.GameRepository;
import org.example.cardgames.repository.entities.GameEntity;
import org.example.cardgames.repository.mappers.GameEntityMapper;
import org.example.cardgames.repository.stores.GameStore;
import org.example.cardgames.service.models.BluffGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameStoreImpl implements GameStore {

  @Autowired
  private final GameRepository gameRepository;

  @Override
  public BluffGame getByGameId(String gameId) {
    return gameRepository.findByGameId(gameId).map(GameEntityMapper.INSTANCE::toService)
        .orElseThrow(() -> {
          log.error("Game {} not found", gameId);
          return new RuntimeException("Game not found!");
        });
  }

  @Override
  public BluffGame save(BluffGame game) {
    GameEntity entityRequest = GameEntityMapper.INSTANCE.toRepository(game);
    entityRequest.setCreatedBy(game.getStartedBy().intValue());
    entityRequest.setUpdatedBy(game.getStartedBy().intValue());
    return GameEntityMapper.INSTANCE.toService(gameRepository.save(entityRequest));
  }
}
