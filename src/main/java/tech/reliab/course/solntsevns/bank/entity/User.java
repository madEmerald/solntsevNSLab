package tech.reliab.course.solntsevns.bank.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private static Long currentId;
    private Long id;

    private String fullName;
    private LocalDate dateOfBirth;
    private String workplace;
    private double monthlyIncome;
    private int creditScore;
    private Bank bank;

    public User(String fullName, LocalDate dateOfBirth, Bank bank, String workplace, double monthlyIncome, int creditScore) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.workplace = workplace;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
        this.bank = bank;
    }
}
