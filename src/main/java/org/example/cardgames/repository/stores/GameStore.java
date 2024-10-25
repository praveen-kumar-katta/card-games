package org.example.cardgames.repository.stores;

import org.example.cardgames.service.models.BluffGame;

public interface GameStore {

  BluffGame getByGameId(String gameId);

  BluffGame save(BluffGame game);

}
