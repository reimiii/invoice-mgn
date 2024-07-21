package franxx.code.invoice.dao;

import franxx.code.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualAccountDao extends PagingAndSortingRepository<VirtualAccount, String> {
}
