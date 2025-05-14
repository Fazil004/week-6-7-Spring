package com.bridgelabz.employeepayrollapp;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService service;

    @GetMapping("/")
    public List<EmployeePayroll> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
        log.info("Creating employee: {}", dto);
        return service.createEmployee(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayroll updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        log.info("Updating employee with id {}: {}", id, dto);
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Deleted employee with id " + id;
    }

    @GetMapping("/department/{department}")
    public List<EmployeePayroll> getEmployeesByDepartment(@PathVariable String department) {
        return service.getEmployeesByDepartment(department);
    }
}
