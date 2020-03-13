package lk.pathum.controller;

import lk.pathum.model.Account;
import lk.pathum.model.Payment;
import lk.pathum.service.AccountService;
import lk.pathum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/savePayment",method = RequestMethod.POST)
    public Payment savePayment(@RequestBody Payment payment){
        return paymentService.save(payment);
    }

    @RequestMapping(value = "/saveAccount",method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account account){
        return accountService.save(account);
    }

    @RequestMapping(value = "/pay/{by}/{to}/{amount}", method = RequestMethod.GET)
    public void credit(@PathVariable int by,@PathVariable int to,@PathVariable float amount){
        accountService.updateAccount(by,to,amount); //paymentService.creditAccount()
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public Account fetchAccounts(@PathVariable int id){ return accountService.fetchAccount(id); }

}
