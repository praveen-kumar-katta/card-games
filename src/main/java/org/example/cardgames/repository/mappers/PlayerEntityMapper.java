package org.example.cardgames.repository.mappers;

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
  PlayerEntity toEntity(CreatePlayerRequest request);

  Player fromEntity(PlayerEntity playerEntity);
}
