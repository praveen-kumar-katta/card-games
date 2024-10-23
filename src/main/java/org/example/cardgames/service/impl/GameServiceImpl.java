package org.example.cardgames.service.impl;

import static org.example.cardgames.service.models.enums.GameStatus.INIT;
import static org.example.cardgames.service.models.enums.PlayerRoomStatus.JOINED;
import static org.example.cardgames.service.models.enums.RoomStatus.CLOSED;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cardgames.repository.GameRepository;
import org.example.cardgames.repository.GameSessionRepository;
import org.example.cardgames.repository.RoomPlayersRepository;
import org.example.cardgames.repository.entities.GameEntity;
import org.example.cardgames.repository.mappers.GameEntityMapper;
import org.example.cardgames.repository.mappers.GameSessionEntityMapper;
import org.example.cardgames.repository.mappers.RoomEntityMapper;
import org.example.cardgames.repository.mappers.RoomPlayersEntityMapper;
import org.example.cardgames.repository.stores.RoomStore;
import org.example.cardgames.service.GameService;
import org.example.cardgames.service.models.BluffGame;
import org.example.cardgames.service.models.GameSession;
import org.example.cardgames.service.models.Room;
import org.example.cardgames.service.models.RoomPlayer;
import org.example.cardgames.service.models.enums.RoomStatus;
import org.example.cardgames.service.strategies.DeckSizeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

  @Autowired
  private final DeckSizeStrategy deckSizeStrategy;

  @Autowired
  private final GameRepository gameRepository;

  @Autowired
  private final RoomStore roomStore;

  @Autowired
  private final RoomPlayersRepository roomPlayersRepository;

  @Autowired
  private final GameSessionRepository gameSessionRepository;

  @Override
  public BluffGame createGame(String roomId) {
    Room room = RoomEntityMapper.INSTANCE.toService(
        roomStore.findByRoomId(roomId).orElseThrow(() -> {
          log.error("Room not found with id {}", roomId);
          return new RuntimeException("Room not found!");
        }));
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

  private BluffGame saveGameAndSessions(BluffGame game) {
    game.setId(UUID.randomUUID().toString());
    BluffGame savedGame = saveGame(game);
    List<GameSession> gameSessions = game.getPlayerIds().stream().map(
        playerId -> GameSession.builder().gameId(savedGame.getId()).playerId(playerId)
            .playerCards(Collections.emptyList()).build()).toList();
    saveGameSessions(gameSessions);
    return savedGame;
  }

  private BluffGame saveGame(BluffGame game) {
    GameEntity entityRequest = GameEntityMapper.INSTANCE.toRepository(game);
    entityRequest.setCreatedBy(game.getStartedBy().intValue());
    entityRequest.setUpdatedBy(game.getStartedBy().intValue());
    return GameEntityMapper.INSTANCE.toService(gameRepository.save(entityRequest));
  }

  private List<GameSession> saveGameSessions(List<GameSession> gameSessions) {
    return GameSessionEntityMapper.INSTANCE.toService(
        gameSessionRepository.saveAll(GameSessionEntityMapper.INSTANCE.toRepository(gameSessions)));
  }
}
