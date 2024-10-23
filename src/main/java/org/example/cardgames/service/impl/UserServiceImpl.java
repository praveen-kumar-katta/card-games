package org.example.cardgames.service.impl;

import static org.example.cardgames.service.models.enums.PlayerRoomStatus.DROPPED;
import static org.example.cardgames.service.models.enums.PlayerRoomStatus.JOINED;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cardgames.model.CreatePlayerRequest;
import org.example.cardgames.repository.PlayerRepository;
import org.example.cardgames.repository.RoomPlayersRepository;
import org.example.cardgames.repository.entities.RoomPlayersEntity;
import org.example.cardgames.repository.mappers.PlayerEntityMapper;
import org.example.cardgames.repository.mappers.RoomEntityMapper;
import org.example.cardgames.repository.mappers.RoomPlayersEntityMapper;
import org.example.cardgames.repository.stores.RoomStore;
import org.example.cardgames.service.UserService;
import org.example.cardgames.service.models.Player;
import org.example.cardgames.service.models.Room;
import org.example.cardgames.service.models.RoomPlayer;
import org.example.cardgames.service.models.enums.PlayerRoomStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  @Autowired
  private final PlayerRepository playerRepository;
  @Autowired
  private final RoomStore roomStore;
  @Autowired
  private final RoomPlayersRepository roomPlayersRepository;

  @Override
  public Player createPlayer(CreatePlayerRequest request) {
    playerRepository.findByMobile(request.getMobile()).ifPresent((player) -> {
      throw new RuntimeException("Customer mobile " + request.getMobile() + " already exists!");
    });
    return PlayerEntityMapper.INSTANCE.toService(
        playerRepository.save(PlayerEntityMapper.INSTANCE.fromService(request)));
  }

  @Override
  public Player getPlayer(Long id) {
    return PlayerEntityMapper.INSTANCE.toService(playerRepository.findById(id)).orElse(null);
  }

  @Override
  public boolean joinRoom(String roomId, Long playerId) {
    Optional<Room> roomOptional = getRoom(roomId);
    Optional<Player> playerOptional = fetchPlayer(playerId);
    getByRoomIdAndPlayerIdAndStatus(roomId, playerId, JOINED).ifPresent(roomPlayer -> {
      log.error("Player {} is already in room {}", playerId, roomId);
      throw new RuntimeException("Player is already in the room!");
    });

    roomPlayersRepository.save(RoomPlayersEntityMapper.INSTANCE.fromService(
        RoomPlayer.builder().roomId(roomId).playerId(playerId).status(JOINED).build()));
    return true;
  }

  private Optional<RoomPlayersEntity> getByRoomIdAndPlayerIdAndStatus(String roomId, Long playerId,
      PlayerRoomStatus status) {
    return roomPlayersRepository.findByRoomIdAndPlayerIdAndStatus(roomId, playerId, status);
  }

  private Optional<Player> fetchPlayer(Long playerId) {
    Optional<Player> playerOptional = PlayerEntityMapper.INSTANCE.toService(
        playerRepository.findById(playerId));

    if (playerOptional.isEmpty()) {
      log.error("Player not registered!");
      throw new RuntimeException("Player not registered in the system!");
    }
    return playerOptional;
  }

  private Optional<Room> getRoom(String roomId) {
    Optional<Room> roomOptional = RoomEntityMapper.INSTANCE.toService(
        roomStore.findByRoomId(roomId));
    if (roomOptional.isEmpty()) {
      log.error("Room not found to add new player. RoomId: {}", roomId);
      throw new RuntimeException("Room not found!");
    }
    return roomOptional;
  }

  @Override
  public boolean exitRoom(String roomId, Long playerId) {
    Optional<Room> roomOptional = getRoom(roomId);
    Optional<Player> playerOptional = fetchPlayer(playerId);
    if (getByRoomIdAndPlayerIdAndStatus(roomId, playerId, DROPPED).isEmpty()) {
      log.error("Player {} is not in room {}!", playerId, roomId);
      throw new RuntimeException("Player is not in room!");
    }

    roomPlayersRepository.save(RoomPlayersEntityMapper.INSTANCE.fromService(
        RoomPlayer.builder().roomId(roomId).playerId(playerId).status(DROPPED).build()));
    return true;
  }
}
