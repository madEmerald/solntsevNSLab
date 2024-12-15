package tech.reliab.course.solntsevns.bank.service;

import tech.reliab.course.solntsevns.bank.entity.*;

public interface BankService {
    Bank createBank(String name);

    Bank getBank(Long id);

    void deleteBank(Long id);

    void addOffice(Long bankId, BankOffice office);

    void addEmployee(Long bankId, Employee employee);

    void addUser(Long bankId, User user);

    void deleteOffice(Long bankId, BankOffice office);

    void deleteEmployee(Bank bank, Employee employee);

    void deleteUser(Long bankId, User user);
}