package org.example.cardgames.service.actions.users.executors;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.model.JoinRoomRequest;
import org.example.cardgames.model.UserAction;
import org.example.cardgames.model.UserActionRequest;
import org.example.cardgames.service.UserService;
import org.example.cardgames.service.actions.users.UserCommandExecutor;
import org.example.cardgames.service.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinRoomCommandExecutor implements UserCommandExecutor {

  @Autowired
  private final UserService userService;

  @Override
  public String name() {
    return UserAction.joinroom.name();
  }

  @Override
  public Player execute(Long playerId, UserActionRequest request) {
    if (request instanceof JoinRoomRequest joinRoomRequest) {
      userService.joinRoom(joinRoomRequest.getRoomId(), playerId);
    }
    return null;
  }
}
