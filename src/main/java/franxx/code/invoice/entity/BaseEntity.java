package franxx.code.invoice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({
    AuditingEntityListener.class,
})
@Data
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @CreatedBy
  @Column(name = "created_by")
  private String cratedBy;

  @LastModifiedBy
  @Column(name = "updated_by")
  private String updatedBy;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "status_record")
  @NotNull @Enumerated(EnumType.STRING)
  private StatusRecord statusRecord = StatusRecord.ACTIVE;
}
