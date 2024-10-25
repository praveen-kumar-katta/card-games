package org.example.cardgames.service.actions.games;

import org.example.cardgames.model.GameActionRequest;

public interface GameCommandExecutor {

  Object execute(String gameId, GameActionRequest request);

}
