package org.example.cardgames.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Data;
import org.example.cardgames.service.models.enums.RoomStatus;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "room")
@Where(clause = "deleted=0")
public class RoomEntity extends BaseModel {

  @Column(name = "room_id")
  private String roomId;

  @Enumerated(EnumType.STRING)
  private RoomStatus status;

  @Column(name = "hosted_by")
  private Long hostedBy;

  @Override
  public boolean isNew() {
    return Objects.isNull(roomId);
  }

  @Override
  public void setId(Long id) {
    super.setId(id);
  }
}
