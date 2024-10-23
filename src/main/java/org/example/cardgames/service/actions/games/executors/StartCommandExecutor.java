package org.example.cardgames.service.actions.games.executors;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.model.GameAction;
import org.example.cardgames.model.GameActionRequest;
import org.example.cardgames.model.StartGameRequest;
import org.example.cardgames.service.GameService;
import org.example.cardgames.service.actions.games.GameCommandExecutor;
import org.example.cardgames.service.models.BluffGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StartCommandExecutor implements GameCommandExecutor {

  @Autowired
  private final GameService gameService;

  @Override
  public String name() {
    return GameAction.start.name();
  }

  @Override
  public BluffGame execute(Long playerId, GameActionRequest request) {
    StartGameRequest startGameRequest = (StartGameRequest) request;
    return gameService.createGame(startGameRequest.getRoomId());
  }
}
