package com.project.KFC.controllers;

import com.project.KFC.services.CategoryService;
import com.project.KFC.services.CustomerService;
import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CategoryService categoryService;
    private final PurchasesService purchasesService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;

    @Autowired
    public AdminController(CategoryService categoryService, PurchasesService purchasesService, CustomerService customerService, EmployeeService employeeService) {
        this.categoryService = categoryService;
        this.purchasesService = purchasesService;
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("purchases", purchasesService.findAllByPurchasesStatus())
                .addAttribute("customers", customerService.findAll())
                .addAttribute("employees", employeeService.findAllActiveWorker());
        return "admin/index";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return "redirect:/admin";
    }

}
