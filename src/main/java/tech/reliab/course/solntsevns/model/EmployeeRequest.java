package tech.reliab.course.solntsevns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String fullName;
    private LocalDate birthDate;
    private String position;
    private int bankOfficeId;
    private double salary;
    private boolean canIssueLoans;
}