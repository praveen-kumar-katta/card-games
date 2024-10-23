package org.example.cardgames.repository.mappers;

import java.util.Optional;
import org.example.cardgames.model.CreatePlayerRequest;
import org.example.cardgames.repository.entities.PlayerEntity;
import org.example.cardgames.service.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerEntityMapper {

  PlayerEntityMapper INSTANCE = Mappers.getMapper(PlayerEntityMapper.class);

  @Mapping(target = "createdBy", constant = "1")
  @Mapping(target = "updatedBy", constant = "1")
  PlayerEntity fromService(CreatePlayerRequest request);

  Player toService(PlayerEntity playerEntity);

  default Optional<Player> toService(Optional<PlayerEntity> playerEntityOpt) {
    return playerEntityOpt.map(this::toService);
  }
}
