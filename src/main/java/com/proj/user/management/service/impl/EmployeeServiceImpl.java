package com.proj.user.management.service.impl;

import com.proj.user.management.entity.Employee;
import com.proj.user.management.repository.EmployeeRepository;
import com.proj.user.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee successfully added..";
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.findById(id).isEmpty()) throw new RuntimeException("Cannot find employee with Id");
        Employee emp = employeeRepository.findById(id).get();
        if (Objects.nonNull(employee.getFirstName())) emp.setFirstName(employee.getFirstName());
        if (Objects.nonNull(employee.getLastName())) emp.setLastName(employee.getLastName());
        if (Objects.nonNull(employee.getOffice())) emp.setOffice(employee.getOffice());
        if (Objects.nonNull(employee.getEmail())) emp.setEmail(employee.getEmail());
       return employeeRepository.save(emp);
    }

    @Override
    public String deleteEmployee(Long id) {
        if (employeeRepository.findById(id).isEmpty()) throw new RuntimeException("Cannot find employee with Id");
        employeeRepository.deleteById(id);
        return "Successfully deleted...";
    }

    @Override
    public Employee findEmployeeById(Long id) {
        if (employeeRepository.findById(id).isEmpty()) throw new RuntimeException("Cannot find employee with Id");
        return employeeRepository.findById(id).get();
    }
}
