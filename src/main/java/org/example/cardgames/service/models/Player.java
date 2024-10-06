package org.example.cardgames.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

  private String id;
  private String name;
  private String mobile;
  private String avatar;
}
