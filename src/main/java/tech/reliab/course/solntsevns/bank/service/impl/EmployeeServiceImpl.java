package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;
import tech.reliab.course.solntsevns.bank.service.EmployeeService;

import java.time.LocalDate;


public class EmployeeServiceImpl implements EmployeeService {
    /**
     * Создает нового сотрудника.
     *
     * @param fullName ФИО сотрудника
     * @param dateOfBirth дата рождения
     * @param position должность
     * @param bank банк, в котором работает сотрудник
     * @param salary размер зарплаты
     * @param canIssueLoans может ли выдавать кредиты
     * @param bankOffice банковский офис, в котором работает
     * @return созданный EmployeeEntity
     */
    public Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans, BankOffice bankOffice) {
        Employee employee = new Employee(fullName, dateOfBirth, position, bank, salary, canIssueLoans, bankOffice);
        return employee;
    }

    /**
     * Создает нового сотрудника.
     *
     * @param fullName ФИО сотрудника
     * @param dateOfBirth дата рождения
     * @param position должность
     * @param bank банк, в котором работает сотрудник
     * @param salary размер зарплаты
     * @param canIssueLoans может ли выдавать кредиты
     * @return созданный EmployeeEntity
     */
    public Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans) {
        Employee employee = new Employee(fullName, dateOfBirth, position, bank, salary, canIssueLoans);
        return employee;
    }
}
