package org.example.cardgames.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Data;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "game_sessions")
@Where(clause = "deleted=0")
public class GameSessionEntity extends BaseModel {

  @Column(name = "game_id")
  private String gameId;

  @Column(name = "player_id")
  private Long playerId;

  @Column(name = "player_cards")
  private String playerCards;

  @Override
  public boolean isNew() {
    return Objects.isNull(this.getId());
  }

  @Override
  public void setId(Long id) {
    super.setId(id);
  }
}
