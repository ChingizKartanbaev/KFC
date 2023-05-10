package com.project.KFC.controllers;

import com.project.KFC.enums.PurchasesStatusEnum;
import com.project.KFC.models.Purchases;
import com.project.KFC.services.CustomerService;
import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.PurchasesService;
import com.project.KFC.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchases")
public class PurchasesController {

    private final PurchasesService purchasesService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;

    @Autowired
    public PurchasesController(PurchasesService purchasesService, CustomerService customerService, EmployeeService employeeService) {
        this.purchasesService = purchasesService;
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @GetMapping("/buy")
    public String buy(Model model) {
        Long number = purchasesService.buy();
        if (number == 0){
            return "product/error";
        }
        model.addAttribute("purchases", number);
        return "product/success";
    }

    @GetMapping("/myPurchases")
    public String myPurchases(Model model) {
        model.addAttribute("status", purchasesService.checkPurchases());
        return "product/checkPurchase";
    }

    @GetMapping("/getProcessPurchases")
    public String getProcessPurchases(Model model) {
        model.addAttribute("purchases", customerService.getProcessPurchasesFromCustomer());
        return "purchases/index";
    }

    @PutMapping("/complete/{id}")
    public String completeOrder(@PathVariable("id") Long id) {
        Purchases purchases = purchasesService.findById(id);
        purchases.setEmployee(employeeService.getEmployee());
        purchases.setPurchasesStatus(PurchasesStatusEnum.READY);
        purchasesService.save(purchases);
        return "redirect:/purchases/getProcessPurchases";
    }

    @GetMapping("/completed")
    public String completed(Model model) {
        model.addAttribute("purchases", purchasesService.findAllByPurchasesStatus());
        return "purchases/finished";
    }
}
