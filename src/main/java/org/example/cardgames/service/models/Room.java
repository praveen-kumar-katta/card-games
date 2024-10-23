package org.example.cardgames.service.models;

import static org.example.cardgames.service.models.enums.RoomStatus.OPEN;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.cardgames.service.models.enums.RoomStatus;

@Data
@AllArgsConstructor
@Builder
public class Room {

  private String id;
  private String roomId;
  private RoomStatus status;
  private Long hostedBy;


  public Room() {
    this.roomId = UUID.randomUUID().toString();
    status = OPEN;
  }
}
