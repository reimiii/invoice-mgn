package franxx.code.invoice.dao;

import franxx.code.invoice.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends PagingAndSortingRepository<Payment, String> {
}
