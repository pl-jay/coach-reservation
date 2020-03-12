package lk.pathum.service;

import lk.pathum.model.Payment;
import lk.pathum.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment fetchPayments(Integer id) {
        return null;// paymentRepository.findById(id);
    }

    @Override
    @Modifying
    @Query("update account a set a.amount = a.amount + :amount where a.accId = :to")
    public boolean updateAccount(int by, int to, float amount) {
        return true;
    }


}
