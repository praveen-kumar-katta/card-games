package org.example.cardgames.service.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.cardgames.service.models.enums.GameStatus;

@Data
@Builder
@AllArgsConstructor
public class BluffGame {

  private String id;
  private String roomId;
  private List<Long> playerIds;
  private Integer decks;
  private Long startedBy;
  private GameStatus status;
}
