package com.egor.spring.spring_data_jpa.controller;



import com.egor.spring.spring_data_jpa.entity.Employee;
import com.egor.spring.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> showAllEmployee() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;

    }


    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return " delete employee id " + id;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }
    @GetMapping("employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name){
        List<Employee> employees = employeeService.findAllByName(name);
        return employees;
    }
}