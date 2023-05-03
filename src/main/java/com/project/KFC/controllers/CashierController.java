package com.project.KFC.controllers;

import com.project.KFC.enums.TaskStatusEnum;
import com.project.KFC.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cashier")
public class CashierController {

    private final TaskService taskService;

    @Autowired
    public CashierController(TaskService service) {
        this.taskService = service;
    }


    //TODO
    @PostMapping("/getMyTask/{id}}")
    public String getMyTask(Model model, @PathVariable("id") Long id){
        model.addAttribute("tasks", taskService.findTaskByIdAndStatus(id, TaskStatusEnum.UNFINISHED));
        return "cashier/task";
    }

    //TODO
    @GetMapping("/getCompleteTask/{id}}")
    public String getCompleteTask(Model model, @PathVariable("id") Long id){
        model.addAttribute("tasks", taskService.findTaskByIdAndStatus(id, TaskStatusEnum.FINISHED));
        return "cashier/task";
    }

}
