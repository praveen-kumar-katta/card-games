package org.example.cardgames.utils;

import static org.example.cardgames.service.models.enums.CardCharacter.JOKER;
import static org.example.cardgames.service.models.enums.Symbol.CLUB;
import static org.example.cardgames.service.models.enums.Symbol.DIAMOND;
import static org.example.cardgames.service.models.enums.Symbol.HEART;
import static org.example.cardgames.service.models.enums.Symbol.SPADE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;
import org.example.cardgames.service.models.enums.CardCharacter;
import org.example.cardgames.service.models.enums.Symbol;

@UtilityClass
public class SuiteUtils {

  private static List<String> getCharactersWithoutJoker() {
    return Arrays.stream(CardCharacter.values()).filter(card -> !card.isJoker())
        .map(CardCharacter::name).toList();
  }

  public static List<String> getSeries(Symbol symbol) {
    return getCharactersWithoutJoker().stream().map(character -> getCard(symbol, character))
        .collect(Collectors.toList());
  }

  private static String getCard(Symbol symbol, String character) {
    return symbol.name().concat("_").concat(symbol.getColour().name()).concat("_")
        .concat(character);
  }

  public static List<String> getSuite() {
    List<String> cards = getSuiteWithoutJoker();
    cards.add("1".concat("_").concat(JOKER.name()));
    cards.add("2".concat("_").concat(JOKER.name()));
    return cards;
  }

  private static List<String> getSuiteWithoutJoker() {
    List<String> cards = getSeries(CLUB);
    cards.addAll(getSeries(SPADE));
    cards.addAll(getSeries(DIAMOND));
    cards.addAll(getSeries(HEART));
    return cards;
  }

  public static List<String> getSuite(String cover) {
    return getSuite().parallelStream().map(card -> cover.concat("_").concat(card)).toList();
  }
}
