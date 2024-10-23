package org.example.cardgames.controller.mappers;

import org.example.cardgames.service.models.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomsResponseMapper {

  RoomsResponseMapper INSTANCE = Mappers.getMapper(RoomsResponseMapper.class);

  org.example.cardgames.model.Room fromService(Room room);
}
