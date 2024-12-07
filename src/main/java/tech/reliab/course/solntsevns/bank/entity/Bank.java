package tech.reliab.course.solntsevns.bank.entity;


public class Bank {
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
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    public int getNumberOfATMs() {
        return numberOfATMs;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getRating() {
        return rating;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
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
