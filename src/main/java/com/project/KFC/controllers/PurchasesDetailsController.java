package com.project.KFC.controllers;

import com.project.KFC.services.PurchasesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchasesDetails")
public class PurchasesDetailsController {

    private final PurchasesDetailService purchasesDetailService;

    @Autowired
    public PurchasesDetailsController(PurchasesDetailService purchasesDetailService) {
        this.purchasesDetailService = purchasesDetailService;
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("details", purchasesDetailService.findAllByPurchasesId(id));
        return "purchases/details";
    }
}
