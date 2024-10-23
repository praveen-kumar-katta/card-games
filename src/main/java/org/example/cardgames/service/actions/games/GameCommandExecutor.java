package org.example.cardgames.service.actions.games;

import org.example.cardgames.model.GameActionRequest;
import org.example.cardgames.model.UserActionRequest;
import org.example.cardgames.service.models.BluffGame;

public interface GameCommandExecutor {

  String name();

  BluffGame execute(Long playerId, GameActionRequest request);

}
