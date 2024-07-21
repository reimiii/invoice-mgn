package franxx.code.invoice.dao;

import franxx.code.invoice.entity.PaymentProvider;
import franxx.code.invoice.entity.VirtualAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VirtualAccountDao extends JpaRepository<VirtualAccount, String> {
  Optional<VirtualAccount> findByPaymentProviderAndCompanyIdAndAccountNumber(
      PaymentProvider paymentProvider, String companyId, String accountNumber
  );
}
