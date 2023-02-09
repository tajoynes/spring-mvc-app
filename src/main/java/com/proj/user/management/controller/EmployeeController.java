package com.proj.user.management.controller;

import com.proj.user.management.entity.Employee;
import com.proj.user.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PostMapping("/new")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable(value = "employeeId")Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable(value = "employeeId")Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable(value = "employeeId")Long id){
        return employeeService.findEmployeeById(id);
    }


}
