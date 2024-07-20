package franxx.code.invoice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity @Data
@Table(name = "invoice")
public class Invoice extends BaseEntity {

  @NotNull @NotEmpty @Size(min = 3, max = 100)
  @Column(name = "invoice_number")
  private String invoiceNumber;

  @NotNull
  private Boolean paid = false;

  @NotNull @Column(name = "due_date")
  private LocalDate dueDate;

  @NotNull @NotEmpty @Size(min = 3, max = 100)
  private String description;

  @NotNull @Min(0)
  private BigDecimal amount;

  @NotNull
  @ManyToOne @JoinColumn(name = "id_invoice_type")
  private InvoiceType invoiceType;
}
