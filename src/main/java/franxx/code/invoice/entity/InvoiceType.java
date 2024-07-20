package franxx.code.invoice.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity @Data
public class InvoiceType extends BaseEntity {
  @NotNull @NotEmpty @Size(min = 3, max = 100)
  private String code;

  @NotNull @NotEmpty @Size(min = 3, max = 100)
  private String name;
}
