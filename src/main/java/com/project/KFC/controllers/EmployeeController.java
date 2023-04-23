package com.project.KFC.controllers;

import com.project.KFC.services.EmployeeService;
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
        model.addAttribute("workers", employeeService.findAll());
        return "director/allWorkers";
    }

    @GetMapping("/{id}/editSalaryUp")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("worker", employeeService.findById(id));
        return "director/formToCahngeSalary";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("salary")double salary, @PathVariable("id") Long id) {
        employeeService.changeSalaryUp(id, salary);
        return "redirect:/employee/showAllWorkers";
    }

}
