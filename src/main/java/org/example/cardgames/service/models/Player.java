package org.example.cardgames.service.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

  private Long id;
  private String name;
  private String mobile;
  private String avatar;
  private List<String> cards;
  private BluffGame game;
  private Room room;
}
