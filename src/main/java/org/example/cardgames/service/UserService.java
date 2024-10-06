package org.example.cardgames.service;

import org.example.cardgames.model.CreatePlayerRequest;
import org.example.cardgames.service.models.Player;

public interface UserService {

  Player createPlayer(CreatePlayerRequest request);

  Player getPlayer(Long id);
}