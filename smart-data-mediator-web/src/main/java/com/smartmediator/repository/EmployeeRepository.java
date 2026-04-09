package com.smartmediator.repository;

import com.smartmediator.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    @Query("SELECT SUM(e.salary) FROM Employee e")
    double getTotalSalary();

    @Query(value="SELECT d.name AS label, COUNT(e.id) AS value FROM employee e JOIN department d ON e.department_id=d.id GROUP BY d.name", nativeQuery=true)
    List<Map<String,Object>> getEmployeesPerDepartment();

}