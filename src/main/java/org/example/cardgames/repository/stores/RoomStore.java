package org.example.cardgames.repository.stores;

import java.util.Optional;
import org.example.cardgames.repository.entities.RoomEntity;
import org.example.cardgames.service.models.Room;

public interface RoomStore {

  Optional<RoomEntity> findByRoomId(String roomId);

  Room save(Room room);

  Room update(Room room);

}
