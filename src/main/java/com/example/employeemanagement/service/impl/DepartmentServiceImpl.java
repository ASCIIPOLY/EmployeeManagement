package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(final DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Iterable<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Department not exist with id: " + id));
    }

    public Department add(final Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Long id, Department department) {
        if (id == department.getId()) {
            return departmentRepository.save(department);
        } else {
            throw new NotFoundException("Url id and posted data id not same");
        }
    }

    public void delete(Long id) {
        departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Department not exist with id: " + id));
        departmentRepository.deleteById(id);
    }
}
