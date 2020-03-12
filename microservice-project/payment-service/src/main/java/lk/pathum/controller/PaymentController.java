package lk.pathum.controller;

import lk.pathum.model.Account;
import lk.pathum.model.Payment;
import lk.pathum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/save")
    public Payment save(@RequestBody Payment payment){
        System.out.println(payment.toString());
        return paymentService.save(payment); }

    @RequestMapping("/credit/{by}/{to}/{amount}")
    public boolean credit(@PathVariable int by,@PathVariable int to,@PathVariable float amount){
        return paymentService.updateAccount(by,to,amount); //paymentService.creditAccount()
    }

    @RequestMapping("/debit")
    public boolean debit(@RequestBody Payment payment){ return true; }

    @RequestMapping("/sampleP")
    public Payment sample(){
        return new Payment();
    }

    @RequestMapping("/sampleA")
    public Account sampleAccount(){
        return new Account();
    }

    @RequestMapping("/test")
    public Payment testAccount() {

        Payment payment = new Payment();
        payment.setId(4534);
        payment.setAmount(1234);
        payment.setRemarks("advance");

        Account account = new Account();
        account.setId(1001);
        account.setBalance(3500);
        account.setUser(123);

        Account account2 = new Account();
        account.setId(1002);
        account.setBalance(2500);
        account.setUser(124);

        List<Payment> p = new ArrayList<>();
        p.add(payment);

//        payment.setConsumer(account);
//        account.setConsumerPayment(p);
//        payment.setAmount(4500);

        return payment;
    }


}
