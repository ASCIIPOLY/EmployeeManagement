package com.example.employeemanagement.service.impl;


import com.example.employeemanagement.exception.NotFoundException;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not exist with id: " + id));
    }

    public Employee add(final Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        if (id == employee.getId()) {
            return employeeRepository.save(employee);
        } else {
            throw new NotFoundException("Url id and posted data id not same");
        }
    }

    public void delete(Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not exist with id: " + id));
        employeeRepository.deleteById(id);
    }
}
