package org.example.cardgames.repository.stores.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cardgames.repository.RoomRepository;
import org.example.cardgames.repository.entities.RoomEntity;
import org.example.cardgames.repository.mappers.RoomEntityMapper;
import org.example.cardgames.repository.stores.RoomStore;
import org.example.cardgames.service.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomStoreImpl implements RoomStore {

  @Autowired
  private final RoomRepository roomRepository;

  @Override
  public Optional<RoomEntity> findByRoomId(String roomId) {
    return roomRepository.findByRoomId(roomId);
  }

  @Override
  public Room save(Room room) {
    return RoomEntityMapper.INSTANCE.toService(save(RoomEntityMapper.INSTANCE.fromService(room)));
  }

  @Override
  public Room update(Room room) {
    RoomEntity newRoomEntity = RoomEntityMapper.INSTANCE.fromService(room);
    Optional<RoomEntity> existingRoomOptional = roomRepository.findByRoomId(room.getRoomId());
    if (existingRoomOptional.isEmpty()) {
      log.error("Room not found with id {}", room.getRoomId());
      throw new RuntimeException("Room not found");
    }
    RoomEntity mappedRoom = RoomEntityMapper.INSTANCE.entityMap(newRoomEntity,
        existingRoomOptional.get());
    return RoomEntityMapper.INSTANCE.toService(save(mappedRoom));
  }

  private RoomEntity save(RoomEntity roomEntity) {
    return roomRepository.save(roomEntity);
  }
}
