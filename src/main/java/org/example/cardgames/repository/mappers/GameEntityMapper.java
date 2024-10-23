package org.example.cardgames.repository.mappers;

import org.example.cardgames.repository.entities.GameEntity;
import org.example.cardgames.service.models.BluffGame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameEntityMapper {

  GameEntityMapper INSTANCE = Mappers.getMapper(GameEntityMapper.class);

  @Mapping(target = "gameId", source = "id")
  @Mapping(target = "id", ignore = true)
  GameEntity toRepository(BluffGame game);

  @Mapping(target = "id", source = "gameId")
  BluffGame toService(GameEntity game);
}
