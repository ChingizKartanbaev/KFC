package com.project.KFC.controllers;

import com.project.KFC.services.ProductsService;
import com.project.KFC.services.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        model.addAttribute("products", productsService.findAll());
        return "product/index";
    }


    @PostMapping("/addToTheBasket/{id}")
    public String addToTheBasket(@PathVariable("id") Long id) {
        productsService.addToTheBasket(id);
        return "redirect:/product/getAll";
    }


    @GetMapping("/myCart")
    public String myCart(Model model) {
        model.addAttribute("carts", productsService.getBasket())
                .addAttribute("totalCost", productsService.getTotalCost());
        return "product/myCart";
    }

    @PutMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable("id") Long id) {
        productsService.deleteFromCart(id);
        return "redirect:/product/myCart";
    }

}

