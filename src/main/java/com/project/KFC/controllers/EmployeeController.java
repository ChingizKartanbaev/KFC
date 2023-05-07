package com.project.KFC.controllers;


import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ProductsService productsService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ProductsService productsService) {
        this.employeeService = employeeService;
        this.productsService = productsService;
    }

    @GetMapping()
    public String indexEmployee(Model model) {
        model.addAttribute("user", employeeService.getEmployee())
                .addAttribute("employee",employeeService.getEmployee())
                .addAttribute("menus", productsService.findAll());
        return "index";
    }

    @GetMapping("/showAllWorkers")
    public String showAllWorkers(Model model){
        model.addAttribute("workers", employeeService.findAllActiveWorker());
        return "director/allWorkers";
    }

    @GetMapping("/getAllWorkers")
    public String getAllWorkers(Model model){
        model.addAttribute("workers", employeeService.findAllActiveWorker());
        return "director/showAllWorker";
    }

}
