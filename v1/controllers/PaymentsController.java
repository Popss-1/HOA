package com.bigbrain.v1.controllers;

import com.bigbrain.v1.DAOandRepositories.PaymentRepository;
import com.bigbrain.v1.models.Payments;
import com.bigbrain.v1.models.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // user finished filling payment form
    //TODO receive payments obj
    @PostMapping("/user/userbills/{billidfk}/payment")
    public void submitPayment(@PathVariable int billidfk, HttpSession httpSession){
        Users user = (Users) httpSession.getAttribute("user");
        //Payments payment = new Payments(billidfk, creditCardNumber, cvv, expirationMonth, expirationYear, amountPaid, user.getUserIdPK());
        //paymentRepository.save(payment);
    }
}
