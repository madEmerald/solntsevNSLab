package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.*;
import tech.reliab.course.solntsevns.bank.service.BankService;


public class BankServiceImpl implements BankService {
    /**
     * Создать новый банк.
     * @param name имя банка
     * @return созданный банк
     */
    public Bank createBank(String name) {
        Bank bank = new Bank(name);
        bank.setRating(generateRandomRating());
        bank.setTotalMoney(generateRandomMoney());
        bank.setInterestRate(calculateInterestRate(bank.getRating()));
        return bank;
    }

    /**
     * Добавить офис в банк.
     * @param bank банк
     * @param office офис
     */
    public void addOfficeToBank(Bank bank, BankOffice office) {
        bank.addOffice();

        office.setBank(bank);
    }

    /**
     * Добавить банкомат в банк.
     * @param bank банк
     * @param atm банкомат
     */
    public void addATMToBank(Bank bank, BankAtm atm) {
        bank.addAtm();

        atm.setBank(bank);
    }

    /**
     * Добавить сотрудника в банк.
     * @param bank банк
     * @param employee сотрудник
     */
    public void addEmployeeToBank(Bank bank, Employee employee) {
        bank.addEmployee();

        employee.setBank(bank);
        if (employee.getBankOffice().getBank() != bank)
            employee.setBankOffice(null);
    }

    /**
     * Добавить клиента в банк.
     * @param bank банк
     * @param user клиент
     */
    public void addUserToBank(Bank bank, User user) {
        bank.addUser();

        //
    }

    /**
     * Удаляет указанный офис из банка.
     *
     * @param bank банк, из которого удаляется офис
     * @param office офис, который нужно удалить из банка
     */
    public void removeOfficeFromBank(Bank bank, BankOffice office) {
        bank.removeOffice();

        office.setBank(null);
    }

    /**
     * Удаляет указанный банкомат из банка.
     *
     * @param bank банк, из которого удаляется банкомат
     * @param atm банкомат, который нужно удалить из банка
     */
    public void removeATMFromBank(Bank bank, BankAtm atm) {
        bank.removeAtm();

        atm.setBank(null);
    }

    /**
     * Удаляет указанного сотрудника из банка.
     *
     * @param bank банк, из которого удаляется сотрудник
     * @param employee сотрудник, который нужно удалить из банка
     */
    public void removeEmployeeFromBank(Bank bank, Employee employee) {
        bank.removeEmployee();

        employee.setBank(null);
        if (employee.getBankOffice().getBank() == bank)
            employee.setBankOffice(null);
    }

    /**
     * Удаляет указанного клиента из банка.
     *
     * @param bank банк, из которого удаляется клиент
     * @param user клиент, который нужно удалить из банка
     */
    public void removeUserFromBank(Bank bank, User user) {
        bank.removeUser();

        //
    }

    private int generateRandomRating() {
        return (int) (Math.random() * 100);
    }

    private double generateRandomMoney() {
        return Math.random() * 1_000_000;
    }

    private double calculateInterestRate(int rating) {
        double baseRate = Math.random() * 20;
        return baseRate * (100 - rating) / 100;
    }
}