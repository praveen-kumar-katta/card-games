package org.example.cardgames.controller;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.GamesApi;
import org.example.cardgames.model.CardAction;
import org.example.cardgames.model.CreateGameRequest;
import org.example.cardgames.model.Game;
import org.example.cardgames.model.GameAction;
import org.example.cardgames.model.GameActionRequest;
import org.example.cardgames.model.GameActionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GamesApiImpl implements GamesApi {

  @Override
  public ResponseEntity<Game> cardActions(Long userId, String gameId, CardAction command,
      GameActionRequest gameActionRequest) {
    return null;
  }

  @Override
  public ResponseEntity<GameActionResponse> gameActions(String gameId, GameAction command,
      GameActionRequest gameActionRequest) {
    return null;
  }

  @Override
  public ResponseEntity<Game> newGame(CreateGameRequest createGameRequest) {
    return null;
  }
}
