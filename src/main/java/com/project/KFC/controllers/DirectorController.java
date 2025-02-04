package com.project.KFC.controllers;

import com.project.KFC.models.Response.UserEmployee;
import com.project.KFC.models.User;
import com.project.KFC.services.EmployeeService;
import com.project.KFC.services.PositionService;
import com.project.KFC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/director")
public class DirectorController {

    private final EmployeeService employeeService;
    private final UserService userService;
    private final PositionService positionService;

    @Autowired
    public DirectorController(EmployeeService employeeService, UserService userService, PositionService positionService) {
        this.employeeService = employeeService;
        this.userService = userService;
        this.positionService = positionService;
    }

    @GetMapping("/workersControl")
    public String workersControl(Model model){
        model.addAttribute("workers", employeeService.findAllActiveWorker());
        return "director/controlWorker";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("workerData", userService.findById(id));
        return "director/edit";
    }

    @PutMapping("/updatePersonalData/{id}")
    public String updateWorkerData(@ModelAttribute("workerData") User user, @PathVariable("id") Long id) {
        userService.updateEmployee(id, user);
        return "redirect:/director/workersControl";
    }

    @PutMapping("/delete/{id}")
    public String deleteWorker(@PathVariable("id") Long id){
        employeeService.delete(id);
        return "redirect:/director/workersControl";
    }

    @GetMapping("/regWorker")
    public String regWorker(Model model) {
        model.addAttribute("userEmployee", new UserEmployee())
                .addAttribute("position", positionService.findAll());
        return "director/formToAddWorker";
    }

    @PostMapping("/addWorker")
    public String addUser(@ModelAttribute("userEmployee") UserEmployee user) {
        userService.saveWorker(user);
        return "redirect:/director/workersControl";
    }

    @GetMapping("/{id}/editSalaryUp")
    public String upSalary(Model model, @PathVariable("id") Long id) {
        model.addAttribute("worker", employeeService.findById(id));
        return "director/formToChangeSalary";
    }

    @PutMapping("/{id}/Up")
    public String updateUp(@ModelAttribute("salary")double salary, @PathVariable("id") Long id) {
        employeeService.changeSalaryUp(id, salary);
        return "redirect:/employee/showAllWorkers";
    }

    @GetMapping("/{id}/editSalaryLow")
    public String lowSalary(Model model, @PathVariable("id") Long id) {
        model.addAttribute("worker", employeeService.findById(id));
        return "director/formToChangeSalaryLow";
    }

    @PutMapping("/{id}/Low")
    public String updateLow(@ModelAttribute("salary")double salary, @PathVariable("id") Long id) {
        employeeService.changeSalaryLow(id, salary);
        return "redirect:/employee/showAllWorkers";
    }

}
