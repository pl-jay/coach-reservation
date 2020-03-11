package lk.pathum.controller;

import lk.pathum.model.User;
import lk.pathum.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/credit")
    public boolean credit(@RequestBody User user){
        return true; //paymentService.creditAccount()
    }


}
