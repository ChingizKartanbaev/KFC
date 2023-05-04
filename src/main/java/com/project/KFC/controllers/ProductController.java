package com.project.KFC.controllers;

import com.project.KFC.services.ProductsService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "";
    }

}

