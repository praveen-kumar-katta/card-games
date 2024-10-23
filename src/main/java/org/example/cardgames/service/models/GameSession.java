package org.example.cardgames.service.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GameSession {

  private String gameId;
  private Long playerId;
  private List<String> playerCards;
}
