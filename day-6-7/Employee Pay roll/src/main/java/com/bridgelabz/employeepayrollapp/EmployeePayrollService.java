package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    public List<EmployeePayroll> getAllEmployees() {
        return repository.findAll();
    }

    public EmployeePayroll getEmployeeById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public EmployeePayroll createEmployee(EmployeePayrollDTO dto) {
        EmployeePayroll employee = new EmployeePayroll(dto);
        return repository.save(employee);
    }

    public EmployeePayroll updateEmployee(int id, EmployeePayrollDTO dto) {
        EmployeePayroll employee = getEmployeeById(id);
        employee.update(dto);
        return repository.save(employee);
    }

    public void deleteEmployee(int id) {
        EmployeePayroll employee = getEmployeeById(id);
        repository.delete(employee);
    }

    public List<EmployeePayroll> getEmployeesByDepartment(String department) {
        return repository.findEmployeesByDepartment(department);
    }
}
