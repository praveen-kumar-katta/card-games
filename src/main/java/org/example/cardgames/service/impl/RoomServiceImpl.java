package org.example.cardgames.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cardgames.repository.RoomRepository;
import org.example.cardgames.repository.mappers.RoomEntityMapper;
import org.example.cardgames.service.RoomService;
import org.example.cardgames.service.models.Room;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;

  @Override
  public Room createRoom() {
    return RoomEntityMapper.INSTANCE.toService(
        roomRepository.save(RoomEntityMapper.INSTANCE.fromService(new Room())));
  }


}
