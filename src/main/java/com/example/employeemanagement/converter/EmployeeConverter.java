package com.example.employeemanagement.converter;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.DepartmentService;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class EmployeeConverter {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeConverter(final EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    public Employee dtoToEntityForCreate(EmployeeDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee = modelMapper.map(dto, Employee.class);
        employee.setDepartment(getDepartmentById(dto.getDepartmentId()));
        return  employee ;
    }

    public Employee dtoToEntityForUpdate(EmployeeDTO dto) {
        Employee employee = employeeService.getById(dto.getId());
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(getDepartmentById(dto.getDepartmentId()));
        employee.setAge(dto.getAge());
        return employee;
    }

    private Department getDepartmentById(Long id){
        if (id != null) {return departmentService.getById(id);}
        return null ;
    }
}
