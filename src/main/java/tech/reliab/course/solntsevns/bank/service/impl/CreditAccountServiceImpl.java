package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.*;
import tech.reliab.course.solntsevns.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.time.Period;


public class CreditAccountServiceImpl implements CreditAccountService {
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
        return creditAccount;
    }
}