package org.example.cardgames.service;

import org.example.cardgames.service.models.BluffGame;
import org.example.cardgames.service.models.Room;

public interface GameService {

  BluffGame createGame(String roomId);

}
