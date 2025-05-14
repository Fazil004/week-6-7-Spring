package com.bridgelabz.employeepayrollapp;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayroll> getAllEmployees();
    EmployeePayroll getEmployeeById(int id);
    EmployeePayroll createEmployee(EmployeePayrollDTO dto);
    EmployeePayroll updateEmployee(int id, EmployeePayrollDTO dto);
    void deleteEmployee(int id);
    List<EmployeePayroll> getEmployeesByDepartment(String department);
}
