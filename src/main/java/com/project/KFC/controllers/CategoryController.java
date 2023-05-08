package com.project.KFC.controllers;

import com.project.KFC.models.Category;
import com.project.KFC.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService service) {
        this.categoryService = service;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/category";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categories", new Category());
        return "admin/categoryCreateForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("categories") Category category) {
        categoryService.save(category);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return "redirect:/admin";
    }

}
