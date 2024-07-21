package franxx.code.invoice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Entity @Data @Table(name = "payment_provider")
@SQLDelete(sql = "UPDATE payment_provider SET status_record = 'INACTIVE' WHERE id = ?")
@SQLRestriction("status_record = 'ACTIVE'")
public class PaymentProvider extends BaseEntity {
  @NotNull @NotEmpty @Size(min = 3, max = 100)
  private String code;

  @NotNull @NotEmpty @Size(min = 3, max = 100)
  private String name;

  private String logo;
}
