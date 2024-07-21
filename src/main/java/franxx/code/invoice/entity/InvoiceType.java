package franxx.code.invoice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity @Data @Table(name = "invoice_type")
@SQLDelete(sql = "UPDATE invoice_type SET status_record = 'INACTIVE' WHERE id=?")
@Where(clause = "status_record = 'ACTIVE'")
public class InvoiceType extends BaseEntity {
  @NotNull @NotEmpty @Size(min = 3, max = 100)
  private String code;

  @NotNull @NotEmpty @Size(min = 3, max = 100)
  private String name;

  @ManyToMany
  @JoinTable(
      name = "invoice type provider",
      joinColumns = @JoinColumn(name = "id_invoice_type"),
      inverseJoinColumns = @JoinColumn(name = "id_payment_provider")
  )
  private Set<PaymentProvider> paymentProviders = new HashSet<>();
}
