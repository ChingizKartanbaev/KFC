package com.project.KFC.controllers;

import com.project.KFC.services.CustomerService;
import com.project.KFC.services.EmployeeService;
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
    private final CustomerService customerService;
    private final EmployeeService employeeService;

    @Autowired
    public MainController(UserService userService, ProductsService productsService, CustomerService customerService, EmployeeService employeeService) {
        this.userService = userService;
        this.productsService = productsService;
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", customerService.getCustomer() == null ? employeeService.getEmployee() : customerService.getCustomer())
                .addAttribute("customer", customerService.getCustomer())
                    .addAttribute("menus", productsService.findAll())
                .addAttribute("employee",employeeService.getEmployee());
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("user", customerService.getCustomer() == null ? employeeService.getEmployee() : customerService.getCustomer())
                .addAttribute("customer", customerService.getCustomer())
                .addAttribute("employee",employeeService.getEmployee());
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("user", customerService.getCustomer() == null ? employeeService.getEmployee() : customerService.getCustomer())
                .addAttribute("customer", customerService.getCustomer())
                .addAttribute("employee",employeeService.getEmployee());
        return "contact";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("user", customerService.getCustomer() == null ? employeeService.getEmployee() : customerService.getCustomer())
                .addAttribute("customer", customerService.getCustomer())
                .addAttribute("employee",employeeService.getEmployee());
        return "blog";
    }

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
