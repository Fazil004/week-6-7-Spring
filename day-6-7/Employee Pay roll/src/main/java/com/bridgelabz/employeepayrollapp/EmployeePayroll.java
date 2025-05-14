package com.bridgelabz.employeepayrollapp;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@ToString
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String gender;
    private double salary;

    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;

    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    private List<String> department;

    public EmployeePayroll() {}

    public EmployeePayroll(EmployeePayrollDTO dto) {
        this.name = dto.getName();
        this.gender = dto.getGender();
        this.salary = dto.getSalary();
        this.startDate = dto.getStartDate();
        this.note = dto.getNote();
        this.profilePic = dto.getProfilePic();
        this.department = dto.getDepartment();
    }

    public void update(EmployeePayrollDTO dto) {
        this.name = dto.getName();
        this.gender = dto.getGender();
        this.salary = dto.getSalary();
        this.startDate = dto.getStartDate();
        this.note = dto.getNote();
        this.profilePic = dto.getProfilePic();
        this.department = dto.getDepartment();
    }
}
