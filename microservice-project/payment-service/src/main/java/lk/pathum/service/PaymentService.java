package lk.pathum.service;

import lk.pathum.model.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<Payment> getAll();
    Payment save(Payment payment);
    Payment fetchPayments(Integer id);
}
