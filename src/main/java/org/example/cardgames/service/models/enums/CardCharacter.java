package org.example.cardgames.service.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CardCharacter {
  KING(false), QUEEN(false), JACK(false), TEN(false), NINE(false), EIGHT(false), SEVEN(false), SIX(
      false), FIVE(false), FOUR(false), THREE(false), TWO(false), ACE(false), JOKER(true);

  @Getter
  private final boolean joker;

}
