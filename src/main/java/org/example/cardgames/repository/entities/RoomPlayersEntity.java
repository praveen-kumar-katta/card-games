package org.example.cardgames.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Data;
import org.example.cardgames.service.models.enums.PlayerRoomStatus;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "room_players")
@Where(clause = "deleted=0")
public class RoomPlayersEntity extends BaseModel {

  @Column(name = "room_id")
  private String roomId;

  @Column(name = "player_id")
  private Long playerId;

  @Enumerated(EnumType.STRING)
  private PlayerRoomStatus status;

  @Override
  public boolean isNew() {
    return Objects.isNull(getId());
  }

  @Override
  public void setId(Long id) {
    super.setId(id);
  }
}
