package org.example.cardgames.service.actions.games.executors;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.model.GameActionRequest;
import org.example.cardgames.service.GameService;
import org.example.cardgames.service.actions.games.GameCommandExecutor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistributeCommandExecutor implements GameCommandExecutor {

  private final GameService gameService;

  @Override
  public Object execute(String gameId, GameActionRequest request) {
    return gameService.distribute(gameId);
  }
}
