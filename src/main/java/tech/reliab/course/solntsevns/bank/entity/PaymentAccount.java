package tech.reliab.course.solntsevns.bank.entity;

public class PaymentAccount {
    private Long id;
    private User user;

    private Bank bank;
    private double balance;

    public PaymentAccount(User user, Bank bank) {
        this.user = user;
        this.bank = bank;
        this.balance = 0.0; // Начальное значение
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Bank getBankName() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBankName(Bank bank) {
        this.bank = bank;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}