package org.example.cardgames.service;

import org.example.cardgames.service.models.BluffGame;
import org.example.cardgames.service.models.Pool;

public interface GameService {

  BluffGame createGame(String roomId);

  Pool distribute(String gameId);
}
