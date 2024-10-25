package org.example.cardgames.service.strategies.factories;

import org.example.cardgames.service.models.enums.strategies.DistributionStrategy;
import org.example.cardgames.service.strategies.CardDistributionStrategy;
import org.example.cardgames.service.strategies.impl.distribution.RandomDistributionStrategy;
import org.springframework.stereotype.Service;

@Service
public class CardDistributionFactoryImpl {

  public CardDistributionStrategy getByName(DistributionStrategy strategy) {
    return switch (strategy) {
      case random -> new RandomDistributionStrategy();
    };
  }
}
