package franxx.code.invoice.helper;

import franxx.code.invoice.dao.VirtualAccountDao;
import franxx.code.invoice.entity.PaymentProvider;
import franxx.code.invoice.entity.VirtualAccount;
import franxx.code.invoice.exception.VirtualAccountNotFoundException;

public class VirtualAccountHelper {

  public static VirtualAccount checkVaIsPresent(
      VirtualAccountDao virtualAccountDao,
      PaymentProvider paymentProvider,
      String companyId, String accountNumber
  ) throws VirtualAccountNotFoundException {
    return virtualAccountDao
        .findByPaymentProviderAndCompanyIdAndAccountNumber(paymentProvider, companyId, accountNumber)
        .orElseThrow(() -> new VirtualAccountNotFoundException(
            "VA [" + companyId + "/" + accountNumber + "-" + paymentProvider.getCode() + "] not found"
        ));
  }
}
