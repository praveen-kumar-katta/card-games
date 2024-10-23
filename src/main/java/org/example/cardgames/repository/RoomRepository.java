package org.example.cardgames.repository;

import java.util.Optional;
import org.example.cardgames.repository.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

  Optional<RoomEntity> findByRoomId(String roomId);

}
