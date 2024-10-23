package org.example.cardgames.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.cardgames.service.models.enums.PlayerRoomStatus;

@Data
@AllArgsConstructor
@Builder
public class RoomPlayer {

  private String roomId;
  private Long playerId;
  private PlayerRoomStatus status;

}
