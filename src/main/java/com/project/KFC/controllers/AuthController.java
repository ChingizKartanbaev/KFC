package com.project.KFC.controllers;

import com.project.KFC.models.User;
import com.project.KFC.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String auth() {
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/check")
    public String check(@RequestParam String login, @RequestParam String password) {
        String role = userService.auth(login, password);
        switch (role) {
            case "Customer":
                return "redirect:/customer";
            case "Manager", "Director","Cashier":
                return "redirect:/employee";
            case "Admin":
                return "redirect:/admin";
            case "error":
                return "redirect:/error";
        }
        return "redirect:/auth";
    }

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("user", new User());
        return "login/reg";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveCustomer(user);
        return "redirect:/auth";
    }
}
