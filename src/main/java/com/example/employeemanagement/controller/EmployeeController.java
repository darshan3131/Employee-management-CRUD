package com.example.employeemanagement.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(
            @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        return new ResponseEntity<>(
                employeeService.createEmployee(employeeDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(
                employeeService.getAllEmployees()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO
    ) {
        return ResponseEntity.ok(
                employeeService.updateEmployee(id, employeeDTO)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id
    ) {
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}