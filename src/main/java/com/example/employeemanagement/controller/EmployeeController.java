package com.example.employeemanagement.controller;


import com.example.employeemanagement.converter.EmployeeConverter;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController extends AbstractController {

    private final EmployeeService employeeService;
    private final EmployeeConverter employeeConverter;

    public EmployeeController(final EmployeeService employeeService,
                              final EmployeeConverter employeeConverter) {
        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employee> add(@RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = employeeConverter.dtoToEntityForCreate(employeeDTO);
        return new ResponseEntity<>(employeeService.add(newEmployee), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.dtoToEntityForUpdate(employeeDTO);
        return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.OK);
    }
}

