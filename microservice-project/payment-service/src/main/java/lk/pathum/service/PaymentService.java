package lk.pathum.service;

import lk.pathum.model.Account;
import lk.pathum.model.Payment;
import lk.pathum.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<Payment> getAll();
    Payment save(Payment payment);
    Payment fetchPayments(Integer id);

    Payment proceedTransaction(Transaction transaction);
}
