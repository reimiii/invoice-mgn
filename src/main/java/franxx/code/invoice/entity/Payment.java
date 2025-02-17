package franxx.code.invoice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity @Data @Table(name = "payment")
@SQLDelete(sql = "UPDATE payment SET status_record = 'INACTIVE' WHERE id = ?")
@SQLRestriction("status_record = 'ACTIVE'")
public class Payment extends BaseEntity {

  @NotNull
  @ManyToOne @JoinColumn(name = "id_virtual_account")
  private VirtualAccount virtualAccount;

  @NotNull
  private LocalDateTime transactionTime;

  @NotNull @Min(0)
  private BigDecimal amount;
}
