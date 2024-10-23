package org.example.cardgames.service.models.enums;

import static org.example.cardgames.service.models.enums.Colour.BLACK;
import static org.example.cardgames.service.models.enums.Colour.RED;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Symbol {
  HEART(RED), SPADE(BLACK), DIAMOND(RED), CLUB(BLACK);

  private final Colour colour;

  public Colour getColour() {
    return this.colour;
  }
}
