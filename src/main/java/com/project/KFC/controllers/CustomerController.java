package com.project.KFC.controllers;

import com.project.KFC.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public String indexCustomer(Model model) {
        model.addAttribute("user", customerService.getCustomer())
                .addAttribute("customer", customerService.getCustomer());
        return "index";
    }

}
