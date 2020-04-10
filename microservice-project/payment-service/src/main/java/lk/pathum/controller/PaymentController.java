package lk.pathum.controller;

import lk.pathum.model.Account;
import lk.pathum.model.Payment;
import lk.pathum.model.Transaction;
import lk.pathum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/paymentController")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public Payment credit(@RequestBody Transaction transaction){
        return paymentService.proceedTransaction(transaction);
    }

    @GetMapping("/samplePayment")
    public Transaction samplePayment(){
        return new Transaction();
    }

    @GetMapping(value = "/fetchPayments/{id}")
    public Payment fetch(@PathVariable int id){
        return paymentService.fetchPayments(id);
    }

}
