package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.*;
import tech.reliab.course.solntsevns.bank.service.BankOfficeService;
import tech.reliab.course.solntsevns.bank.service.BankService;
import tech.reliab.course.solntsevns.bank.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class BankServiceImpl implements BankService {
    private final Map<Long, Bank> banksTable = new HashMap<>();
    private final Map<Long, List<BankOffice>> officesByBankIdTable = new HashMap<>();
    private final Map<Long, List<User>> usersByBankIdTable = new HashMap<>();
    private BankOfficeService bankOfficeService;
    private UserService clientService;

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

        banksTable.put(bank.getId(), bank);
        officesByBankIdTable.put(bank.getId(), new ArrayList<>());
        usersByBankIdTable.put(bank.getId(), new ArrayList<>());

        return bank;
    }

    /**
     * Получает банк по ID.
     *
     * @param id ID банка.
     * @return Банк с указанным ID или null, если не найден.
     */
    public Bank getBank(Long id) {
        return banksTable.get(id);
    }

    /**
     * Удаляет банк по ID.
     *
     * @param id ID банка.
     */
    public void deleteBank(Long id) {
        banksTable.remove(id);
    }

    /**
     * Добавить офис в банк.
     * @param bankId id банка
     * @param office офис
     */
    public void addOffice(Long bankId, BankOffice office) {
        Bank bank = getBank(bankId);

        office.setBank(bank);
        bank.addOffice();
        bank.setNumberOfATMs(bank.getNumberOfATMs() + office.getNumberOfATMs());
        bank.setTotalMoney(bank.getTotalMoney() + office.getAmountOfMoney());

        List<BankOffice> bankOffices = officesByBankIdTable.get(bankId);
        bankOffices.add(office);
    }

    /**
     * Добавить сотрудника в банк.
     * @param bankId id банка
     * @param employee сотрудник
     */
    public void addEmployee(Long bankId, Employee employee) {
        Bank bank = getBank(bankId);

        bank.addEmployee();

        employee.setBank(bank);
        if (employee.getBankOffice().getBank() != bank)
            employee.setBankOffice(null);
    }

    /**
     * Добавить клиента в банк.
     * @param bankId id банка
     * @param user клиент
     */
    public void addUser(Long bankId, User user) {
        Bank bank = getBank(bankId);

        user.setBank(bank);
        bank.addUser();
        List<User> users = usersByBankIdTable.get(bankId);
        users.add(user);
    }

    /**
     * Удаляет указанный офис из банка.
     *
     * @param bankId id банка
     * @param office офис
     */
    public void deleteOffice(Long bankId, BankOffice office) {
        Bank bank = getBank(bankId);
        office.setBank(null);

        int officeIndex = officesByBankIdTable.get(bankId).indexOf(office);
        bank.removeOffice();
        bank.setNumberOfATMs(bank.getNumberOfATMs() - officesByBankIdTable.get(bankId).get(officeIndex).getNumberOfATMs());
        officesByBankIdTable.get(bankId).remove(officeIndex);
    }

    /**
     * Удаляет указанного сотрудника из банка.
     *
     * @param bank банк
     * @param employee сотрудник
     */
    public void deleteEmployee(Bank bank, Employee employee) {
        bank.removeEmployee();

        employee.setBank(null);
        if (employee.getBankOffice().getBank() == bank)
            bankOfficeService.deleteEmployee(employee.getBankOffice().getId(), employee);
    }

    /**
     * Удаляет указанного клиента из банка.
     *
     * @param bankId id банка
     * @param user клиент
     */
    public void deleteUser(Long bankId, User user) {
        Bank bank = getBank(bankId);
        user.setBank(null);

        usersByBankIdTable.get(bankId).remove(user);

        bank.removeUser();
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