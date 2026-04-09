package com.smartmediator.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@RestController
@CrossOrigin
public class ManageController {

    @Autowired
    JdbcTemplate jdbc;

    @PostMapping("/manage")
    public String manage(@RequestBody Map<String,String> data){

        String table = data.get("database");
        String action = data.get("action");
        String name = data.get("name");
        String email = data.get("email");
        String salary = data.get("salary");

        // Simple console log to verify data arrival
        System.out.println("Action: " + action + " on Table: " + table);

        if(table == null || action == null){
            return "Invalid request: Missing table or action";
        }

        /* MATCHING LOGIC 
           Note: Changed "employees" to "employee" to match your SQL queries
        */
        if(table.equalsIgnoreCase("employee") || table.equalsIgnoreCase("employees")){

            /* ADD EMPLOYEE */
            if(action.equals("add")){
                String sql = "INSERT INTO employee(name,email,salary) VALUES(?,?,?)";
                jdbc.update(sql, name, email, salary);
                return "Employee Added Successfully";
            }

            /* DELETE EMPLOYEE */
            if(action.equals("delete")){
                String sql = "DELETE FROM employee WHERE name=?";
                jdbc.update(sql, name);
                return "Employee Deleted Successfully";
            }

            /* UPDATE EMPLOYEE */
            if(action.equals("update")){
                String sql = "UPDATE employee SET email=?, salary=? WHERE name=?";
                jdbc.update(sql, email, salary, name);
                return "Employee Updated Successfully";
            }
        }

        return "Error: Table '" + table + "' not recognized or action '" + action + "' invalid.";
    }
}