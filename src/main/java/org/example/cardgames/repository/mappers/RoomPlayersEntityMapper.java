package org.example.cardgames.repository.mappers;

import java.util.List;
import org.example.cardgames.repository.entities.RoomPlayersEntity;
import org.example.cardgames.service.models.RoomPlayer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomPlayersEntityMapper {

  RoomPlayersEntityMapper INSTANCE = Mappers.getMapper(RoomPlayersEntityMapper.class);

  RoomPlayersEntity fromService(RoomPlayer roomPlayer);

  List<RoomPlayer> toService(List<RoomPlayersEntity> entities);

  RoomPlayer toService(RoomPlayersEntity entity);

}
