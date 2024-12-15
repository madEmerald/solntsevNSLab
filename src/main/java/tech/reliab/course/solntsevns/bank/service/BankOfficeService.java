package tech.reliab.course.solntsevns.bank.service;

import tech.reliab.course.solntsevns.bank.entity.BankAtm;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;

public interface BankOfficeService {
    BankOffice createOffice(String name, String address, Bank bank, boolean canPlaceAtm, boolean canOfferLoan, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double rentCost);

    void updateOffice(BankOffice office);

    void addAtm(Long officeId, BankAtm atm);

    void deleteAtm(Long officeId, BankAtm atm);

    void updateAmountOfMoney(BankOffice office, double amount);

    void addEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long officeId, Employee employee);


}