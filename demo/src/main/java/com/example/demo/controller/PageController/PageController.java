package com.example.demo.controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }
}

