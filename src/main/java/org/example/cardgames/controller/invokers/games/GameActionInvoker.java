package org.example.cardgames.controller.invokers.games;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.model.GameAction;
import org.example.cardgames.service.GameService;
import org.example.cardgames.service.actions.games.GameCommandExecutor;
import org.example.cardgames.service.actions.games.executors.DistributeCommandExecutor;
import org.example.cardgames.service.actions.games.executors.StartCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameActionInvoker {

  @Autowired
  private final GameService gameService;

  public GameCommandExecutor getByAction(GameAction action) {
    return switch (action) {
      case start -> new StartCommandExecutor(gameService);
      case distribute -> new DistributeCommandExecutor(gameService);
    };
  }

}
