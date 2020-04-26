package lk.pathum.payment.controller;

import lk.pathum.payment.model.Payment;
import lk.pathum.payment.model.Transaction;
import lk.pathum.payment.service.PaymentService;
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
