package com.smartmediator.controller;

import com.smartmediator.repository.EmployeeRepository;
import com.smartmediator.repository.ProjectRepository;
import com.smartmediator.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class DashboardController {

@Autowired
EmployeeRepository employeeRepository;

@Autowired
ProjectRepository projectRepository;

@Autowired
DepartmentRepository departmentRepository;


@GetMapping("/dashboard")

public Map<String,Object> dashboard(){

Map<String,Object> data=new HashMap<>();

data.put("employees",employeeRepository.count());
data.put("projects",projectRepository.count());
data.put("averageSalary",employeeRepository.getAverageSalary());
data.put("departments",departmentRepository.count());

List<Map<String,Object>> deptData=employeeRepository.getEmployeesPerDepartment();

data.put("departmentChart",deptData);

return data;

}

}