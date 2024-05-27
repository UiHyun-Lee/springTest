package com.example.practice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("lo")
    public String hello (Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }
}
