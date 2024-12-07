package tech.reliab.course.solntsevns.bank.entity;

import java.time.LocalDate;

public class CreditAccount {
    private Long id;

    private User user;

    private Bank bank;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberOfMonths;
    private double loanAmount;
    private double monthlyPayment;
    private double interestRate;
    private Employee issuingEmployee;
    private PaymentAccount paymentAccount;

    public CreditAccount(User user, Bank bank, LocalDate startDate, LocalDate endDate, int numberOfMonths, double loanAmount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        this.user = user;
        this.bank = bank;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfMonths = numberOfMonths;
        this.loanAmount = loanAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.issuingEmployee = issuingEmployee;
        this.paymentAccount = paymentAccount;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public Employee getIssuingEmployee() {
        return issuingEmployee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDateDate) {
        this.endDate = endDateDate;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setIssuingEmployee(Employee issuingEmployee) {
        this.issuingEmployee = issuingEmployee;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
}