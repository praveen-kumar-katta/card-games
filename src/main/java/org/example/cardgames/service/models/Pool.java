package org.example.cardgames.service.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Pool {

  private List<String> cards;
  private Bid lastBid;
  private Integer lastBidCount;
  private Player lastBidBy;
  private Player firstBidBy;
  private BluffGame game;
}
