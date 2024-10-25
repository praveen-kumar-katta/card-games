package org.example.cardgames.repository.stores;

import java.util.List;
import org.example.cardgames.service.models.GameSession;

public interface GameSessionStore {

  List<GameSession> getGameSessionsByGameId(String gameId);

  List<GameSession> save(List<GameSession> gameSessions);

}
