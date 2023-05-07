package com.project.KFC.controllers;

import com.project.KFC.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CategoryService categoryService;

    @Autowired
    public AdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/index";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return "redirect:/admin";
    }

}
