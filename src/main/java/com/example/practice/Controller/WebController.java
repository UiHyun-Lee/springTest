package com.example.practice.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = {"/", "/main"})
    public String toMain() {
        return "main";
    }

    @GetMapping("/board")
    public String Toboard() {
        return "board";
    }

    @GetMapping("/signup")
    public String toSignup() {
        return "signup";
    }

    @GetMapping("/language")
    public String ToLanguage() {
        return "language";
    }
}
