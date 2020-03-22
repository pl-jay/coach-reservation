package lk.pathum.controller;

import lk.pathum.model.Account;
import lk.pathum.model.Payment;
import lk.pathum.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accountController")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/saveAccount",method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account account){
        return accountService.save(account);
    }

    @RequestMapping(value = "/pay/{by}/{to}/{amount}", method = RequestMethod.GET)
    public boolean credit(@PathVariable int by,@PathVariable int to,@PathVariable float amount){
       return accountService.updateAccount(by,to,amount); //paymentService.creditAccount()
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public Account fetchAccounts(@PathVariable int id){ return accountService.fetchAccount(id); }

    @GetMapping("/sampleAccount")
    public Account sampleAccount(){
        return new Account();
    }

}
