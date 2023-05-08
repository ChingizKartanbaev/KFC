package com.project.KFC.controllers;

import com.project.KFC.models.Products;
import com.project.KFC.services.CategoryService;
import com.project.KFC.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductsService productsService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductsService productsService, CategoryService categoryService) {
        this.productsService = productsService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "admin/product";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
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

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        productsService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("products", new Products())
                .addAttribute("categories", categoryService.findAll());
        return "admin/productCreateForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("products") Products products) {
        productsService.save(products);
        return "redirect:/product";
    }


}

