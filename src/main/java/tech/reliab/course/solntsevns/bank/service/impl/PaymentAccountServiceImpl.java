package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.PaymentAccount;
import tech.reliab.course.solntsevns.bank.entity.User;
import tech.reliab.course.solntsevns.bank.service.PaymentAccountService;
import tech.reliab.course.solntsevns.bank.service.UserService;

import java.util.HashMap;
import java.util.Map;


public class PaymentAccountServiceImpl implements PaymentAccountService {
    private final Map<Long, PaymentAccount> paymentAccountsTable = new HashMap<>();
    private final UserService userService;

    public PaymentAccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * Создает новый платежный счет.
     *
     * @param user пользователь
     * @param bank банк
     * @return созданный PaymentAccountEntity
     */
    public PaymentAccount createPaymentAccount(User user, Bank bank) {
        PaymentAccount account = new PaymentAccount(user, bank);
        paymentAccountsTable.put(account.getId(), account);
        userService.addPaymentAccount(account.getUser().getId(), account);

        return account;
    }

    public PaymentAccount getPaymentAccount(Long id) {
        return paymentAccountsTable.get(id);
    }

    /**
     * Вносит деньги на платежный счет.
     *
     * @param account платежный счет
     * @param amount сумма для внесения
     */
    public void deposit(PaymentAccount account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
        }
    }

    /**
     * Снимает деньги с платежного счета.
     *
     * @param account платежный счет
     * @param amount сумма для снятия
     * @return true, если снятие успешно; false в противном случае
     */
    public boolean withdraw(PaymentAccount account, double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false; // Неудачное снятие
    }
}