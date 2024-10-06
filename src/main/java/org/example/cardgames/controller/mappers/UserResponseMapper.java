package org.example.cardgames.controller.mappers;

import org.example.cardgames.service.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseMapper {

  UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

  org.example.cardgames.model.Player fromService(Player player);

}
