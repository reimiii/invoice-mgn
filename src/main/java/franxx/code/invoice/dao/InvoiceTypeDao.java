package franxx.code.invoice.dao;

import franxx.code.invoice.entity.InvoiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceTypeDao extends JpaRepository<InvoiceType, String> {
  Optional<InvoiceType> findByCode(String code);
}
