package com.smartmediator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "redirect:/login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        // Simple admin login
        if(username.equals("admin") && password.equals("admin123")) {

            return "redirect:/dashboard.html";

        }

        return "redirect:/login.html";
    }
}