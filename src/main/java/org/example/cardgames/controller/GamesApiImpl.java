package org.example.cardgames.controller;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.GamesApi;
import org.example.cardgames.controller.invokers.games.GameActionInvoker;
import org.example.cardgames.model.CardAction;
import org.example.cardgames.model.CreateGameRequest;
import org.example.cardgames.model.Game;
import org.example.cardgames.model.GameAction;
import org.example.cardgames.model.GameActionRequest;
import org.example.cardgames.model.GameActionResponse;
import org.example.cardgames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GamesApiImpl implements GamesApi {

  @Autowired
  private final GameService gameService;

  @Override
  public ResponseEntity<Game> cardActions(Long userId, String gameId, CardAction command,
      GameActionRequest gameActionRequest) {
    return null;
  }

  @Override
  public ResponseEntity<GameActionResponse> gameActions(String gameId, GameAction command,
      GameActionRequest gameActionRequest) {
    return ResponseEntity.ok().body(new GameActionResponse().data(
        new GameActionInvoker(gameService).getByAction(command)
            .execute(gameId, gameActionRequest)));
  }

  @Override
  public ResponseEntity<Game> newGame(CreateGameRequest createGameRequest) {
    return null;
  }
}
