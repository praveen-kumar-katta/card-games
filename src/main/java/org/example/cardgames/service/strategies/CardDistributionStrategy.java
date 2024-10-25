package org.example.cardgames.service.strategies;

import java.util.List;
import org.example.cardgames.service.models.GameSession;

public interface CardDistributionStrategy {

  List<GameSession> execute(List<Long> playerIds, List<String> cards);

}
