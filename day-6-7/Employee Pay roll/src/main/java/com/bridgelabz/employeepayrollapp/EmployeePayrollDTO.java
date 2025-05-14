package com.bridgelabz.employeepayrollapp;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class EmployeePayrollDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Pattern(regexp = "male|female", message = "Gender should be male or female")
    private String gender;

    @NotNull(message = "Salary cannot be null")
    private Double salary;

    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date should be past or present")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile pic cannot be empty")
    private String profilePic;

    @NotNull(message = "Department should not be null")
    private List<@NotBlank(message = "Department cannot be empty") String> department;
}
