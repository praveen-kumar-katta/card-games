package org.example.cardgames.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "players")
@Where(clause = "deleted=0")
public class PlayerEntity extends BaseModel {

  private String name;
  private String mobile;
  private String avatar;

  @Override
  public boolean isNew() {
    return false;
  }

  @Override
  public void setId(Long id) {
    super.setId(id);
  }
}
