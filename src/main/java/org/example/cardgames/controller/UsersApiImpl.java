package org.example.cardgames.controller;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.UsersApi;
import org.example.cardgames.controller.mappers.UserResponseMapper;
import org.example.cardgames.model.CreatePlayerRequest;
import org.example.cardgames.model.CreatePlayerResponse;
import org.example.cardgames.model.Game;
import org.example.cardgames.model.GetPlayerResponse;
import org.example.cardgames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersApiImpl implements UsersApi {

  @Autowired
  private final UserService userService;

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
}
