package org.example.cardgames.service.actions.users;

import org.example.cardgames.model.UserActionRequest;
import org.example.cardgames.service.models.Player;

public interface UserCommandExecutor {

  String name();

  Player execute(Long playerId, UserActionRequest request);
}
