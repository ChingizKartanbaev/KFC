package com.project.KFC.controllers;

import com.project.KFC.models.Review;
import com.project.KFC.services.CustomerService;
import com.project.KFC.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final ReviewService reviewService;

    @Autowired
    public CustomerController(CustomerService customerService, ReviewService reviewService) {
        this.customerService = customerService;
        this.reviewService = reviewService;
    }

    @GetMapping()
    public String indexCustomer(Model model) {
        model.addAttribute("user", customerService.getCustomer())
                .addAttribute("customer", customerService.getCustomer());
        return "index";
    }

    @GetMapping("/review/{id}")
    public String writeReview(Model model, @PathVariable("id") Long id) {
        model.addAttribute("customer", customerService.findById(id))
                .addAttribute("reviews", new Review());
        return "customer/formToWriteReview";
    }

    @PutMapping("/saveReview/{id}")
    public String saveReview(@ModelAttribute("reviews")Review review, @PathVariable("id") Long id) {
        review.setCustomer(customerService.findById(id));
        reviewService.save(review);
        return "redirect:/customer";
    }
}
