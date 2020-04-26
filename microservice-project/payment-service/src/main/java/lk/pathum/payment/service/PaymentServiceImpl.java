package lk.pathum.payment.service;

import lk.pathum.payment.AccountCommand.AccountCommand;
import lk.pathum.payment.model.Payment;
import lk.pathum.payment.model.Transaction;
import lk.pathum.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

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
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }


    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

    @Override
    public Payment proceedTransaction(Transaction transaction) {
        if(new AccountCommand(transaction, restTemplate, httpHeaders).execute()){
            Payment newPayment = new Payment();
            newPayment.setProvider(transaction.getProvider());
            newPayment.setConsumer(transaction.getConsumer());
            newPayment.setAmount(transaction.getAmount());
            newPayment.setRemarks(transaction.getRemarks());
            paymentRepository.save(newPayment);
            return newPayment;
        }
        return null;
    }
}
