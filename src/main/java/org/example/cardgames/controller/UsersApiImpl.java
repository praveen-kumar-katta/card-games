package org.example.cardgames.controller;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.UsersApi;
import org.example.cardgames.controller.mappers.UserResponseMapper;
import org.example.cardgames.model.CreatePlayerRequest;
import org.example.cardgames.model.CreatePlayerResponse;
import org.example.cardgames.model.Game;
import org.example.cardgames.model.GetPlayerResponse;
import org.example.cardgames.model.JoinRoomRequest;
import org.example.cardgames.model.UserAction;
import org.example.cardgames.model.UserActionRequest;
import org.example.cardgames.model.UserActionResponse;
import org.example.cardgames.service.UserService;
import org.example.cardgames.service.actions.users.UserCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersApiImpl implements UsersApi {

  @Autowired
  private final UserService userService;

  @Autowired
  private final UserCommandExecutor userCommandExecutor;

  @Override
  public ResponseEntity<CreatePlayerResponse> createUser(CreatePlayerRequest createPlayerRequest) {
    return ResponseEntity.ok(new CreatePlayerResponse().data(
        UserResponseMapper.INSTANCE.fromService(userService.createPlayer(createPlayerRequest))));
  }

  @Override
  public ResponseEntity<GetPlayerResponse> getUser(Long userId) {
    return ResponseEntity.ok(new GetPlayerResponse().data(
        UserResponseMapper.INSTANCE.fromService(userService.getPlayer(userId))));
  }

  @Override
  public ResponseEntity<Game> getUserGameInfo(Long userId, String gameId) {
    return null;
  }

  @Override
  public ResponseEntity<UserActionResponse> userActions(Long userId, UserAction command,
      UserActionRequest userActionRequest) {

    if (UserAction.joinroom.equals(command)
        && userActionRequest instanceof JoinRoomRequest joinRoomRequest) {
      UserResponseMapper.INSTANCE.fromService(
          userCommandExecutor.execute(userId, joinRoomRequest));
      return ResponseEntity.ok(new UserActionResponse().data("Successfully joined game room"));
    }
    return null;
  }
}
