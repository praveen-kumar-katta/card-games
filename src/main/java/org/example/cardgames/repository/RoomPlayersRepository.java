package org.example.cardgames.repository;

import java.util.List;
import java.util.Optional;
import org.example.cardgames.repository.entities.RoomPlayersEntity;
import org.example.cardgames.service.models.enums.PlayerRoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomPlayersRepository extends JpaRepository<RoomPlayersEntity, Long> {

  Optional<RoomPlayersEntity> findByRoomIdAndPlayerIdAndStatus(String roomId, Long playerId,
      PlayerRoomStatus status);

  List<RoomPlayersEntity> findAllByRoomIdAndStatus(String roomId, PlayerRoomStatus status);
}
