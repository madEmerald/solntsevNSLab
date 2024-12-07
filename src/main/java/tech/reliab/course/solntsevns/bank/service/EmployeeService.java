package tech.reliab.course.solntsevns.bank.service;

import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;

import java.time.LocalDate;


public interface EmployeeService {
    Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans, BankOffice bankOffice);

    Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans);
}
