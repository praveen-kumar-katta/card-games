package org.example.cardgames.repository.mappers;

import java.util.List;
import org.example.cardgames.repository.entities.GameSessionEntity;
import org.example.cardgames.service.models.GameSession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameSessionEntityMapper {

  GameSessionEntityMapper INSTANCE = Mappers.getMapper(GameSessionEntityMapper.class);


  List<GameSessionEntity> toRepository(List<GameSession> gameSessions);

  @Mapping(target = "playerCards", source = "playerCards", qualifiedByName = "mapPlayerCardsToString")
  GameSessionEntity toRepository(GameSession gameSession);

  List<GameSession> toService(List<GameSessionEntity> entities);

  @Mapping(target = "playerCards", source = "playerCards", qualifiedByName = "mapPlayerCardsToList")
  GameSession toService(GameSessionEntity entity);

  // Custom mapping method to map List<String> to comma-separated String
  @Named("mapPlayerCardsToString")
  default String mapPlayerCardsToString(List<String> playerCards) {
    return playerCards != null ? String.join(",", playerCards) : null;
  }

  // Custom mapping method to map comma-separated String back to List<String>
  @Named("mapPlayerCardsToList")
  default List<String> mapPlayerCardsToList(String playerCards) {
    return playerCards != null ? List.of(playerCards.split(",")) : null;
  }
}
