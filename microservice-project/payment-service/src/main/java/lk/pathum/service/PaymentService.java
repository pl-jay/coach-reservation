package lk.pathum.service;

import lk.pathum.model.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentService {
    List<Payment> getAll();
    Payment save(Payment payment);
    Payment fetchPayments(Integer id);

    @Modifying
    @Query("update account a set a.amount = a.amount + :amount where a.accId = :accId")
    Payment creditAccount(@Param("accId") int accId, @Param("amount") float amount);
}
