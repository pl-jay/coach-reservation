package lk.pathum.service;

import lk.pathum.AccountCommand.AccountCommand;
import lk.pathum.model.Account;
import lk.pathum.model.Payment;
import lk.pathum.model.Transaction;
import lk.pathum.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        return null;// paymentRepository.findById(id);
    }


    HttpHeaders httpHeaders = new HttpHeaders();
    HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

    public Payment proceedTransaction(Transaction transaction) {
        if(new AccountCommand(transaction, restTemplate, httpHeaders).execute()){
            System.out.println("execute true");
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
