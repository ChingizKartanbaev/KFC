package com.project.KFC.controllers;

import com.project.KFC.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService service;

    @Autowired
    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("reviews", service.findAll());
        return "review/reviewTable";
    }

}
