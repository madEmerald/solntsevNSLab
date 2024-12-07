package tech.reliab.course.solntsevns.bank.entity;

import java.time.LocalDate;

public class Employee {
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

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public Bank getBank() {
        return bank;
    }

    public boolean isWorksRemotely() {
        return worksRemotely;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isCanIssueLoans() {
        return canIssueLoans;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    // Setter for fullName
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Setter for dateOfBirth
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Setter for position
    public void setPosition(String position) {
        this.position = position;
    }

    // Setter for bank
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    // Setter for worksRemotely
    public void setWorksRemotely(boolean worksRemotely) {
        this.worksRemotely = worksRemotely;
    }

    // Setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Setter for canIssueLoans
    public void setCanIssueLoans(boolean canIssueLoans) {
        this.canIssueLoans = canIssueLoans;
    }

    // Setter for bankOffice
    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }
}
