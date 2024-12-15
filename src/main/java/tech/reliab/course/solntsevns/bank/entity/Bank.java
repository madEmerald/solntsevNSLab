package tech.reliab.course.solntsevns.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Bank {
    private static Long currentId = 0L;
    private Long id;

    private String name;
    private int numberOfOffices = 0;
    private int numberOfATMs = 0;
    private int numberOfEmployees = 0;
    private int numberOfUsers = 0;
    private int rating;
    private double totalMoney;
    private double interestRate;


    public Bank(String name) {
        this.id = currentId++;
        this.name = name;
    }

    public void addAtm() {
        this.numberOfATMs++;
    }

    public void removeAtm() {
        this.numberOfATMs--;
    }

    public void addEmployee() {
        this.numberOfEmployees++;
    }

    public void removeEmployee() {
        this.numberOfEmployees--;
    }

    public void addUser() {
        this.numberOfUsers++;
    }

    public void removeUser() {
        this.numberOfUsers--;
    }

    public void addOffice() {
        this.numberOfOffices++;
    }

    public void removeOffice() {
        this.numberOfOffices--;
    }
}
