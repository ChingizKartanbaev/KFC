package com.project.KFC.controllers;

import com.project.KFC.services.ProductsService;
import com.project.KFC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    private final UserService userService;
    private final ProductsService productsService;

    @Autowired
    public MainController(UserService userService, ProductsService productsService) {
        this.userService = userService;
        this.productsService = productsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("menus", productsService.findAll());
        return "index";
    }

    @GetMapping("/about")
    public String about() {return "about";}

    @GetMapping("/contact")
    public String contact() {return "contact";}

    @GetMapping("/blog")
    public String blog() {return "blog";}

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

    @GetMapping("/profile/{id}")
    public String profile(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "profile";
    }

}
