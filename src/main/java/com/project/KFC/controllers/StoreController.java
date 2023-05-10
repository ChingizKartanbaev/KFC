package com.project.KFC.controllers;

import com.project.KFC.models.Store;
import com.project.KFC.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("stores", storeService.findAll());
        return "purchases/store";
    }

    @PostMapping("/{id}")
    public String findById(@PathVariable("id") Long id) {
        storeService.setStore(storeService.findById(id));
        return "redirect:/product/getAll";
    }
}
