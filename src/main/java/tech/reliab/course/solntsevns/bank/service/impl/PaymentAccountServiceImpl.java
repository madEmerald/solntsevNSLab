package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.PaymentAccount;
import tech.reliab.course.solntsevns.bank.entity.User;
import tech.reliab.course.solntsevns.bank.service.PaymentAccountService;


public class PaymentAccountServiceImpl implements PaymentAccountService {
    /**
     * Создает новый платежный счет.
     *
     * @param user пользователь, которому принадлежит платежный счет
     * @param bankName название банка, в котором открыт счет
     * @return созданный PaymentAccountEntity
     */
    public PaymentAccount createPaymentAccount(User user, Bank bank) {
        PaymentAccount account = new PaymentAccount(user, bank);
        return account;
    }

    /**
     * Вносит деньги на платежный счет.
     *
     * @param account платежный счет, на который вносятся деньги
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
     * @param account платежный счет, с которого снимаются деньги
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