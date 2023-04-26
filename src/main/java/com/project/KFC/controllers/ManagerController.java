package com.project.KFC.controllers;

import com.project.KFC.models.Response.EmployeeTask;
import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final EmployeeService employeeService;
    private final TaskService taskService;

    @Autowired
    public ManagerController(EmployeeService employeeService, TaskService taskService) {
        this.employeeService = employeeService;
        this.taskService = taskService;
    }

    @GetMapping("/giveTask")
    public String getFromToGiveTask(Model model) {
        model.addAttribute("employees", employeeService.findAllCashier())
                .addAttribute("task", new EmployeeTask());
        return "manager/formToGiveTask";
    }

    @PostMapping("/give")
    public String giveTask(@ModelAttribute("task") EmployeeTask employeeTask) {
        taskService.createTask(employeeTask);
        return "redirect:/employee";
    }
}
