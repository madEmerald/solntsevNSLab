package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.*;
import tech.reliab.course.solntsevns.bank.service.CreditAccountService;
import tech.reliab.course.solntsevns.bank.service.UserService;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class CreditAccountServiceImpl implements CreditAccountService {
    private final Map<Long, CreditAccount> creditAccountsTable = new HashMap<>();
    private final UserService userService;

    public CreditAccountServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * Создает новый кредитный счет.
     *
     * @param user            пользователь, которому принадлежит кредитный счет
     * @param bank            название банка, выдавшего кредит
     * @param startDate       дата начала кредита
     * @param endDate         дата окончания кредита
     * @param loanAmount      сумма кредита
     * @param monthlyPayment  ежемесячный платеж
     * @param interestRate    процентная ставка
     * @param issuingEmployee сотрудник, выдавший кредит
     * @param paymentAccount  платежный счет для погашения кредита
     * @return созданный CreditAccountEntity
     */
    public CreditAccount createCreditAccount(User user, Bank bank, LocalDate startDate, LocalDate endDate, double loanAmount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        Period period = Period.between(startDate, endDate);
        int numberOfMonths = period.getYears() * 12 + period.getMonths();

        CreditAccount creditAccount = new CreditAccount(user, bank, startDate, endDate, numberOfMonths, loanAmount, monthlyPayment, interestRate, issuingEmployee, paymentAccount);
        creditAccountsTable.put(creditAccount.getId(), creditAccount);
        userService.addCreditAccount(creditAccount.getUser().getId(), creditAccount);
        return creditAccount;
    }

    /**
     * Получает кредитный счет по ID.
     *
     * @param id ID кредитного счета.
     * @return Кредитный счет с указанным ID или null, если не найден.
     */
    public CreditAccount getCreditAccountById(Long id) {
        return creditAccountsTable.get(id);
    }
}