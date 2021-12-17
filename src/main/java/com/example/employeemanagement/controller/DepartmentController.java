package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/departments")
public class DepartmentController extends AbstractController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Department>> getAll() {
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ResponseEntity<Department> getOne(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(departmentService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Department> add(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.add(department), HttpStatus.CREATED);
    }

    @RequestMapping(value ="/", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return new ResponseEntity<>(departmentService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(value ="/", method = RequestMethod.PUT)
    public ResponseEntity<Department> update(@RequestParam Long id, @RequestBody Department department) {
        return new ResponseEntity<>(departmentService.update(id, department), HttpStatus.OK);
    }
}
