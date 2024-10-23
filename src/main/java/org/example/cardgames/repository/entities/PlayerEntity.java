package org.example.cardgames.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;
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
    return Objects.isNull(getId());
  }

  @Override
  public void setId(Long id) {
    super.setId(id);
  }
}
