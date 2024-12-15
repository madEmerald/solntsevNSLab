package tech.reliab.course.solntsevns.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentAccount {
    private static Long currentId = 0L;
    private Long id;
    private User user;

    private Bank bank;
    private double balance;

    public PaymentAccount(User user, Bank bank) {
        this.id = currentId++;

        this.user = user;
        this.bank = bank;
        this.balance = 0.0; // Начальное значение
    }
}