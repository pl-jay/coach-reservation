package lk.pathum.payment.repository;

import lk.pathum.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
