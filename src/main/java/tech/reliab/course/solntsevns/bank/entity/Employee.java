package tech.reliab.course.solntsevns.bank.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private static Long currentId = 0L;
    private Long id;

    private String fullName;
    private LocalDate dateOfBirth;
    private String position;

    private Bank bank;

    private boolean worksRemotely;
    private double salary;
    private boolean canIssueLoans;

    private BankOffice bankOffice;

    public Employee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans) {
        this.id = currentId++;

        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.bank = bank;
        this.worksRemotely = true;
        this.salary = salary;
        this.canIssueLoans = canIssueLoans;
        this.bankOffice = bankOffice;
    }

    public Employee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans, BankOffice bankOffice) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.bank = bank;
        this.worksRemotely = false;
        this.salary = salary;
        this.canIssueLoans = canIssueLoans;
        this.bankOffice = bankOffice;
    }
}
