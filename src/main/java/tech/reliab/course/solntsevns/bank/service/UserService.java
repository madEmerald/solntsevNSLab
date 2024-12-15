package tech.reliab.course.solntsevns.bank.service;

import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.CreditAccount;
import tech.reliab.course.solntsevns.bank.entity.PaymentAccount;
import tech.reliab.course.solntsevns.bank.entity.User;

import java.time.LocalDate;

public interface UserService {
    User createUser(String fullName, LocalDate dateOfBirth, Bank bank, String workplace);

    User getUser(Long id);

    void addCreditAccount(Long userId, CreditAccount creditAccount);

    void addPaymentAccount(Long userId, PaymentAccount paymentAccount);

    void deleteCreditAccount(Long userId, CreditAccount creditAccount);

    void deletePaymentAccount(Long userId, PaymentAccount paymentAccount);
}