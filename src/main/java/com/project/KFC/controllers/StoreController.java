package com.project.KFC.controllers;

import com.project.KFC.models.Store;
import com.project.KFC.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getAll")
    public String getAllForAdmin(Model model) {
        model.addAttribute("stores", storeService.findAll());
        return "admin/store";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        storeService.delete(id);
        return "redirect:/store/getAll";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("stores", new Store());
        return "admin/storeCreateForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("stores") Store store) {
        storeService.save(store);
        return "redirect:/store/getAll";
    }

}
