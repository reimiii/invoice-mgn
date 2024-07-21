package franxx.code.invoice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Entity @Data @Table(name = "virtual_account")
@SQLDelete(sql = "UPDATE virtual_account SET status_record = 'INACTIVE' WHERE id=?")
@Where(clause = "status_record = 'ACTIVE'")
public class VirtualAccount extends BaseEntity {

  @NotNull
  @ManyToOne @JoinColumn(name = "id_payment_provider")
  private PaymentProvider paymentProvider;

  @NotNull
  @ManyToOne @JoinColumn(name = "id_invoice")
  private Invoice invoice;

  @Column(name = "company_id")
  @NotNull @NotEmpty @Size(min = 1)
  private String companyId;

  @Column(name = "account_number")
  @NotNull @NotEmpty @Size(min = 1)
  private String accountNumber;

  @Column(name = "virtual_account_type")
  @NotNull @Enumerated(EnumType.STRING)
  private VirtualAccountType virtualAccountType = VirtualAccountType.CLOSED;
}
