package org.example.cardgames.service.impl;

import static org.example.cardgames.service.models.enums.GameStatus.INIT;
import static org.example.cardgames.service.models.enums.PlayerRoomStatus.JOINED;
import static org.example.cardgames.service.models.enums.RoomStatus.CLOSED;
import static org.example.cardgames.service.models.enums.strategies.DistributionStrategy.random;
import static org.example.cardgames.utils.SuiteUtils.getSuitesForNDecks;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cardgames.repository.RoomPlayersRepository;
import org.example.cardgames.repository.mappers.RoomPlayersEntityMapper;
import org.example.cardgames.repository.stores.GameSessionStore;
import org.example.cardgames.repository.stores.GameStore;
import org.example.cardgames.repository.stores.RoomStore;
import org.example.cardgames.service.GameService;
import org.example.cardgames.service.models.BluffGame;
import org.example.cardgames.service.models.GameSession;
import org.example.cardgames.service.models.Pool;
import org.example.cardgames.service.models.Room;
import org.example.cardgames.service.models.RoomPlayer;
import org.example.cardgames.service.models.enums.RoomStatus;
import org.example.cardgames.service.strategies.DeckSizeStrategy;
import org.example.cardgames.service.strategies.factories.CardDistributionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

  @Autowired
  private final DeckSizeStrategy deckSizeStrategy;

  @Autowired
  private final GameStore gameStore;

  @Autowired
  private final RoomStore roomStore;

  @Autowired
  private final RoomPlayersRepository roomPlayersRepository;

  @Autowired
  private final GameSessionStore gameSessionStore;

  @Override
  public BluffGame createGame(String roomId) {
    Room room = roomStore.findByRoomId(roomId).orElseThrow(() -> {
      log.error("Room not found with id {}", roomId);
      return new RuntimeException("Room not found!");
    });
    if (!RoomStatus.OPEN.equals(room.getStatus())) {
      log.error("Room {} is not open", roomId);
      throw new RuntimeException("Room is not open");
    }
    List<RoomPlayer> roomPlayers = RoomPlayersEntityMapper.INSTANCE.toService(
        roomPlayersRepository.findAllByRoomIdAndStatus(roomId, JOINED));
    if (roomPlayers.size() < 2) {
      log.error("Minimum 2 players needed to start the game");
      throw new RuntimeException("Minimum 2 players needed to start the game");
    }
    List<Long> playerIds = roomPlayers.stream().map(RoomPlayer::getPlayerId).toList();
    //TODO use factory pattern for deckSizeStrategy
    BluffGame game = BluffGame.builder().decks(deckSizeStrategy.random(roomPlayers.size()))
        .status(INIT).playerIds(playerIds).startedBy(room.getHostedBy()).roomId(roomId).build();
    BluffGame bluffGame = saveGameAndSessions(game);
    room.setStatus(CLOSED);
    roomStore.update(room);
    return bluffGame;
  }

  @Override
  public Pool distribute(String gameId) {
    BluffGame bluffGame = gameStore.getByGameId(gameId);
    List<GameSession> currentGameSessions = gameSessionStore.getGameSessionsByGameId(gameId);
    List<Long> playerIds = currentGameSessions.stream().map(GameSession::getPlayerId)
        .collect(Collectors.toList());

    List<String> allCards = getSuitesForNDecks(bluffGame.getDecks());
    List<GameSession> distributions = new CardDistributionFactoryImpl().getByName(random)
        .execute(playerIds, allCards);

    return new Pool(Collections.emptyList(), null, 0, null, null, bluffGame, distributions);

  }

  private BluffGame saveGameAndSessions(BluffGame game) {
    game.setId(UUID.randomUUID().toString());
    BluffGame savedGame = gameStore.save(game);
    List<GameSession> gameSessions = game.getPlayerIds().stream().map(
        playerId -> GameSession.builder().gameId(savedGame.getId()).playerId(playerId)
            .playerCards(Collections.emptyList()).build()).toList();
    gameSessionStore.save(gameSessions);
    return savedGame;
  }
}
