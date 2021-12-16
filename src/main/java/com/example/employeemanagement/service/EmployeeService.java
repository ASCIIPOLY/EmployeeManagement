package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;

public interface EmployeeService {

    Iterable<Employee> getAll();

    Employee getById(Long id);

    Employee add(Employee employee);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
