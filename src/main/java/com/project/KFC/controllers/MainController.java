package com.project.KFC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }
}