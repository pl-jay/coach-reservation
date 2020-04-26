package lk.pathum.payment.service;

import lk.pathum.payment.model.Payment;
import lk.pathum.payment.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<Payment> getAll();
    Payment save(Payment payment);
    Payment fetchPayments(Integer id);

    Payment proceedTransaction(Transaction transaction);
}
