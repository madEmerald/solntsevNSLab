package tech.reliab.course.solntsevns.bank.service;

import tech.reliab.course.solntsevns.bank.entity.BankAtm;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;

public interface BankOfficeService {
    BankOffice createOffice(String name, String address, Bank bank, boolean canPlaceAtm, boolean canOfferLoan, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double rentCost);

    void updateOffice(BankOffice office);

    void addAtmToOffice(BankOffice office, BankAtm atm);

    void removeAtmFromOffice(BankOffice office, BankAtm atm);

    void updateAmountOfMoney(BankOffice office, double amount);
}