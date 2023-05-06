package com.project.KFC.controllers;

import com.project.KFC.services.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchases")
public class PurchasesController {

    private final PurchasesService purchasesService;

    @Autowired
    public PurchasesController(PurchasesService purchasesService) {
        this.purchasesService = purchasesService;
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
}
