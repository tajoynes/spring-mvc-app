package com.proj.user.management.service;

import com.proj.user.management.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String addEmployee(Employee employee);

    List<Employee> findAllEmployees();

    Employee updateEmployee(Long id, Employee employee);

    String deleteEmployee(Long id);

    Employee findEmployeeById(Long id);
}
