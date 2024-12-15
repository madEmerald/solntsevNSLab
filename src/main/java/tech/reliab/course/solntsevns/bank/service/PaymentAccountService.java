package tech.reliab.course.solntsevns.bank.service;

import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.PaymentAccount;
import tech.reliab.course.solntsevns.bank.entity.User;

public interface PaymentAccountService {
    PaymentAccount createPaymentAccount(User user, Bank bank);

    void deposit(PaymentAccount account, double amount);

    boolean withdraw(PaymentAccount account, double amount);

    PaymentAccount getPaymentAccount(Long id);
}