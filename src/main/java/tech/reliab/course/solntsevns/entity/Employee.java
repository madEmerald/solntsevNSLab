package tech.reliab.course.solntsevns.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String position;

    @ManyToOne
    private Bank bank;

    @Column(nullable = false)
    private boolean worksRemotely;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private boolean canIssueLoans;

    @ManyToOne
    private BankOffice bankOffice;

    public Employee(String fullName, LocalDate dateOfBirth, String position, BankOffice bankOffice, double salary, boolean canIssueLoans) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.bank = bankOffice.getBank();
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
