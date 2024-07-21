package franxx.code.invoice.dao;

import franxx.code.invoice.entity.InvoiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceTypeDaoTest {

  @Autowired
  private InvoiceTypeDao invoiceTypeDao;

  @Test
  void insertInvoiceType() {
    var it = new InvoiceType();
    it.setCode("IT-001");
    it.setName("Invoice type test");
    assertNull(it.getId());
    invoiceTypeDao.save(it);
    assertNotNull(it.getId());

    assertNotNull(it.getUpdatedAt());
    assertNotNull(it.getCreatedAt());
  }
}