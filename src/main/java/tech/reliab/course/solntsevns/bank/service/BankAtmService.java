package tech.reliab.course.solntsevns.bank.service;

import tech.reliab.course.solntsevns.bank.entity.BankAtm;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;


public interface BankAtmService {
    BankAtm createAtm(String name, Bank bank, BankOffice office, Employee servicingEmployee, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double maintenanceCost);

    void updateAtm(BankAtm atm);

    void updateAmountOfMoney(BankAtm atm, double amount);
}