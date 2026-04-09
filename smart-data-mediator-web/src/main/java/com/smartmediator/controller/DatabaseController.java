package com.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class DatabaseController {

    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/tables")
    public List<String> getTables(){

        String sql =
        "SELECT table_name FROM information_schema.tables WHERE table_schema='hr_system'";

        return jdbc.queryForList(sql, String.class);
    }
}