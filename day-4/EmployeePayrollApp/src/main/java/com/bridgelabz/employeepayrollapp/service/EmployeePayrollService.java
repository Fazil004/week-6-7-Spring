package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.EmployeePayroll;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    public List<EmployeePayroll> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<EmployeePayroll> getEmployeeById(int id) {
        return repository.findById(id);
    }

    public EmployeePayroll createEmployee(EmployeePayroll employee) {
        return repository.save(employee);
    }

    public EmployeePayroll updateEmployee(EmployeePayroll employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
