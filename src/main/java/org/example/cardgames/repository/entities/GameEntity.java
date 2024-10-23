package org.example.cardgames.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Data;
import org.example.cardgames.service.models.enums.GameStatus;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "game")
@Where(clause = "deleted=0")
public class GameEntity extends BaseModel {

  @Column(name = "game_id")
  private String gameId;

  @Column(name = "room_id")
  private String roomId;

  @Column(name = "started_by")
  private Long startedBy;

  @Column(name = "decks_used")
  private Integer decks;

  @Enumerated(EnumType.STRING)
  private GameStatus status;

  @Column(name = "winner_id")
  private Long winnerId;

  @Column(name = "next_player_id")
  private Long nextPlayerId;

  @Override
  public boolean isNew() {
    return Objects.isNull(this.gameId);
  }

  @Override
  public void setId(Long id) {
    super.setId(id);
  }
}
