package org.example.cardgames.repository.mappers;

import java.util.Optional;
import org.example.cardgames.repository.entities.RoomEntity;
import org.example.cardgames.service.models.Room;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomEntityMapper {

  RoomEntityMapper INSTANCE = Mappers.getMapper(RoomEntityMapper.class);

  Room toService(RoomEntity roomEntity);

  default Optional<Room> toService(Optional<RoomEntity> roomEntityOpt) {
    return roomEntityOpt.map(this::toService);
  }

  RoomEntity fromService(Room room);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  RoomEntity entityMap(RoomEntity input, @MappingTarget RoomEntity output);
}
