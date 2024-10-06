package org.example.cardgames.repository.entities;


import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
@Data
public abstract class BaseModel implements Persistable<Long>, Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(name = "created_by")
  private Integer createdBy;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_by")
  private Integer updatedBy;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  private boolean deleted;

  protected void setId(Long id) {
    this.id = id;
  }
}
