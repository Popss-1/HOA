package com.bigbrain.v1.controllers;

import com.bigbrain.v1.DAOandRepositories.PaymentRepository;
import com.bigbrain.v1.models.Bills;
import com.bigbrain.v1.models.Payments;
import com.bigbrain.v1.models.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentsController {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // user finished filling payment form
    @GetMapping("/user/userbills/{billidfk}/payment")
    public String paymentForm(@PathVariable int billidfk, HttpSession httpSession, Model model){
        Users user = (Users) httpSession.getAttribute("user");
        Payments newPayment = new Payments(billidfk, user.getUserIdPK());
        model.addAttribute("newPayment", newPayment);
        return "paymentform";
    }
    @PostMapping("/user/userbills/{billidfk}/payment")
        public void submitPayment(@ModelAttribute("newPayment") Payments newPayment){
        paymentRepository.save(newPayment);
    }
}
