package franxx.code.invoice.dao;

import franxx.code.invoice.entity.InvoiceType;
import franxx.code.invoice.entity.StatusRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "/sql/delete-invoce-type.sql")
class InvoiceTypeDaoTest {

  @Autowired
  private InvoiceTypeDao invoiceTypeDao;

  @BeforeEach
  void setUp() {
    {
      var it1 = new InvoiceType();
      it1.setCode("IT-001");
      it1.setName("Invoice type test 1");
      invoiceTypeDao.save(it1);
      System.out.println(it1.getId());
    }
    {
      var it2 = new InvoiceType();
      it2.setCode("IT-002");
      it2.setName("Invoice type test 2");
      invoiceTypeDao.save(it2);
    }
    {
      var it3 = new InvoiceType();
      it3.setCode("IT-003");
      it3.setName("Invoice type test 3");
      it3.setStatusRecord(StatusRecord.INACTIVE);
      invoiceTypeDao.save(it3);
    }
  }

  @Test
  void insertInvoiceType() {
    var it = new InvoiceType();
    it.setCode("IT-010");
    it.setName("Test Insert");
    assertNull(it.getId());
    invoiceTypeDao.save(it);
    assertNotNull(it.getId());

    assertNotNull(it.getUpdatedAt());
    assertNotNull(it.getCreatedAt());
    assertEquals(it.getCreatedAt(), it.getUpdatedAt());

    it.setName("Test Update");
    it = invoiceTypeDao.save(it);
    assertNotEquals(it.getCreatedAt(), it.getUpdatedAt());
  }

  @Test
  void softDeleteQuery() {
    long countRecord = invoiceTypeDao.count();

    assertEquals(2, countRecord);
  }

  @Test
  void deletedSoftDelete() {
    InvoiceType invoiceType = invoiceTypeDao.findByCode("IT-001").orElse(null);
    invoiceTypeDao.delete(invoiceType);

    long countRecord = invoiceTypeDao.count();
    System.out.println("jumlah:" + countRecord);

    assertEquals(1, countRecord);
  }
}