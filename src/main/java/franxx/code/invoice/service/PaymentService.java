package franxx.code.invoice.service;

import franxx.code.invoice.dao.VirtualAccountDao;
import franxx.code.invoice.entity.PaymentProvider;
import franxx.code.invoice.entity.VirtualAccount;
import franxx.code.invoice.exception.VirtualAccountAlreadyPaidException;
import franxx.code.invoice.exception.VirtualAccountNotFoundException;
import franxx.code.invoice.helper.VirtualAccountHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service @Transactional
@RequiredArgsConstructor
public class PaymentService {

  private final VirtualAccountDao virtualAccountDao;

  private static void checkVaAlreadyPaid(
      PaymentProvider paymentProvider,
      String companyId, String accountNumber,
      VirtualAccount virtualAccount
  ) throws VirtualAccountAlreadyPaidException {
    if (virtualAccount.getInvoice().getPaid()) {
      throw new VirtualAccountAlreadyPaidException(
          "VA [" + companyId + "/" + accountNumber + "-" + paymentProvider.getCode() + "] already paid"
      );
    }
  }

  public void pay(
      PaymentProvider paymentProvider,
      String companyId, String accountNumber,
      BigDecimal amount, String reference
  ) throws VirtualAccountNotFoundException, VirtualAccountAlreadyPaidException {
    // cek apakah va ada?
    VirtualAccount virtualAccount = VirtualAccountHelper
        .checkVaIsPresent(virtualAccountDao, paymentProvider, companyId, accountNumber);

    // cek apakah va sudah lunas
    checkVaAlreadyPaid(paymentProvider, companyId, accountNumber, virtualAccount);

    // cek apakah amount pembayaran > nilai tagihan
    // update status va menjadi lunas
    // update status invoice menjadi lunas
    // insert ke table payment
    // notifikasi next fase
  }
}
