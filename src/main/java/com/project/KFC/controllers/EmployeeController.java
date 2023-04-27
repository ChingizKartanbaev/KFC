package com.project.KFC.controllers;


import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.PositionService;
import com.project.KFC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String indexEmployee(Model model) {
        model.addAttribute("user", employeeService.getEmployee())
                .addAttribute("employee",employeeService.getEmployee());
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
