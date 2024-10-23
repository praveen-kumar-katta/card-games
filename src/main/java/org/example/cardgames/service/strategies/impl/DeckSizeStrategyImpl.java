package org.example.cardgames.service.strategies.impl;

import org.example.cardgames.service.strategies.DeckSizeStrategy;
import org.springframework.stereotype.Service;

@Service
public class DeckSizeStrategyImpl implements DeckSizeStrategy {

  @Override
  public int random(Integer size) {
    return 2;
  }
}
