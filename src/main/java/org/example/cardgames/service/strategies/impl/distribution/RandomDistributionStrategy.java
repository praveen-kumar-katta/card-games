package org.example.cardgames.service.strategies.impl.distribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.cardgames.service.models.GameSession;
import org.example.cardgames.service.strategies.CardDistributionStrategy;
import org.springframework.stereotype.Service;

@Service
public class RandomDistributionStrategy implements CardDistributionStrategy {

  @Override
  public List<GameSession> execute(List<Long> playerIds, List<String> cards) {

    int capacity = cards.size() / playerIds.size();
    List<GameSession> distributions = new ArrayList<>();

    for (Long playerId : playerIds) {
      Collections.shuffle(cards);
      List<String> currentPlayerCards = cards.subList(0, capacity);
      cards = cards.subList(capacity, cards.size());
      distributions.add(
          GameSession.builder().playerId(playerId).playerCards(currentPlayerCards).build());
    }
    return distributions;
  }
}
