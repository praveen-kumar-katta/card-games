package org.example.cardgames.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cardgames.model.CreatePlayerRequest;
import org.example.cardgames.repository.PlayerRepository;
import org.example.cardgames.repository.mappers.PlayerEntityMapper;
import org.example.cardgames.service.UserService;
import org.example.cardgames.service.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  @Autowired
  private final PlayerRepository playerRepository;

  @Override
  public Player createPlayer(CreatePlayerRequest request) {
    return PlayerEntityMapper.INSTANCE.fromEntity(
        playerRepository.save(PlayerEntityMapper.INSTANCE.toEntity(request)));
  }

  @Override
  public Player getPlayer(Long id) {
    return PlayerEntityMapper.INSTANCE.fromEntity(playerRepository.findById(id).orElse(null));
  }
}
