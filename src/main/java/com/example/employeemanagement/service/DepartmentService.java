package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Department;

public interface DepartmentService {

    Iterable<Department> getAll();

    Department getById(Long id);

    Department add(Department department);

    Department update(Long id, Department department);

    String delete(Long id);
}
