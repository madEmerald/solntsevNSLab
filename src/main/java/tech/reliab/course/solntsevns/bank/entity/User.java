package tech.reliab.course.solntsevns.bank.entity;

import java.time.LocalDate;

public class User {
    private Long id;

    private String fullName;
    private LocalDate dateOfBirth;
    private String workplace;
    private double monthlyIncome;
    private int creditScore;

    public User(String fullName, LocalDate dateOfBirth, String workplace, double monthlyIncome, int creditScore) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.workplace = workplace;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
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

    public String getWorkplace() {
        return workplace;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }
}
