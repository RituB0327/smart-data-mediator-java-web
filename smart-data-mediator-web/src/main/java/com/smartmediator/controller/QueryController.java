package com.smartmediator.controller;

import com.smartmediator.entity.*;
import com.smartmediator.repository.*;
import com.smartmediator.service.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class QueryController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    QueryService queryService;


    /* ================= ADD APIs (FIXED) ================= */

    @PostMapping("/add/employee")
    public String addEmployee(@RequestBody Employee e){
        employeeRepository.save(e);
        return "Employee Added";
    }

    @PostMapping("/add/client")
    public String addClient(@RequestBody Client c){
        clientRepository.save(c);
        return "Client Added";
    }

    @PostMapping("/add/project")
    public String addProject(@RequestBody Project p){
        projectRepository.save(p);
        return "Project Added";
    }

    @PostMapping("/add/department")
    public String addDepartment(@RequestBody Department d){
        departmentRepository.save(d);
        return "Department Added";
    }


    /* ================= EXISTING ANALYZE ================= */

    @GetMapping("/analyze")
    public Map<String,Object> analyze(@RequestParam String query){

        String normalized = queryService.normalize(query);
        String intent = queryService.detectIntent(normalized);

        List<Map<String,Object>> data = new ArrayList<>();

        if(normalized.contains("department")){
            List<Department> list = departmentRepository.findAll();
            for(Department d : list){
                Map<String,Object> row = new HashMap<>();
                row.put("label", d.getName());
                row.put("value", d.getId());
                data.add(row);
            }
        }

        else if(normalized.contains("client")){
            List<Client> list = clientRepository.findAll();
            for(Client c : list){
                Map<String,Object> row = new HashMap<>();
                row.put("label", c.getName());
                row.put("value", c.getId());
                data.add(row);
            }
        }

        else if(normalized.contains("project")){
            List<Project> list = projectRepository.findAll();
            for(Project p : list){
                Map<String,Object> row = new HashMap<>();
                row.put("label", p.getName());
                row.put("value", p.getId());
                data.add(row);
            }
        }

        else if(normalized.contains("employee")){
            List<Employee> list = employeeRepository.findAll();
            for(Employee e : list){
                Map<String,Object> row = new HashMap<>();
                row.put("label", e.getName());
                row.put("value", e.getSalary());
                data.add(row);
            }
        }

        QueryHistory h = new QueryHistory();
        h.setQueryText(query);
        h.setOperation(intent);
        h.setResult("OK");
        h.setCreatedAt(LocalDateTime.now());

        queryRepository.save(h);

        Map<String,Object> response = new HashMap<>();
        response.put("data", data);
        response.put("chartType", queryService.suggestChart(intent));
        response.put("intent", intent);

        return response;
    }

}