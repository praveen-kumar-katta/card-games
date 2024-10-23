package org.example.cardgames.controller;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.RoomsApi;
import org.example.cardgames.controller.mappers.RoomsResponseMapper;
import org.example.cardgames.model.CreateRoomResponse;
import org.example.cardgames.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomsApiImpl implements RoomsApi {

  @Autowired
  private final RoomService roomService;

  @Override
  public ResponseEntity<CreateRoomResponse> createRoom() {
    return ResponseEntity.ok(new CreateRoomResponse().data(
        RoomsResponseMapper.INSTANCE.fromService(roomService.createRoom())));
  }

  @Override
  public ResponseEntity<CreateRoomResponse> getRoom(String roomId) {
    return null;
  }
}
