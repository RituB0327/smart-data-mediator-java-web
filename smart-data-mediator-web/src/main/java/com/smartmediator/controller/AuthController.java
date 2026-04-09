package com.smartmediator.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin

public class AuthController {

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin123";

    @PostMapping("/login")

    public Map<String,String> login(@RequestBody Map<String,String> loginData){

        String username = loginData.get("username");
        String password = loginData.get("password");

        Map<String,String> response = new HashMap<>();

        if(username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)){

            response.put("status","success");

        }
        else{

            response.put("status","fail");

        }

        return response;

    }

}