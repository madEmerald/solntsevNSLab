package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;
import tech.reliab.course.solntsevns.bank.service.BankOfficeService;
import tech.reliab.course.solntsevns.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Long, Employee> employeesTable = new HashMap<>();
    private final BankOfficeService bankOfficeService;

    public EmployeeServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
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
     * @param bankOffice банковский офис, в котором работает
     * @return созданный EmployeeEntity
     */
    public Employee createEmployee(String fullName, LocalDate dateOfBirth, String position, Bank bank, double salary, boolean canIssueLoans, BankOffice bankOffice) {
        Employee employee = new Employee(fullName, dateOfBirth, position, bank, salary, canIssueLoans, bankOffice);

        employeesTable.put(employee.getId(), employee);
        bankOfficeService.addEmployee(employee.getBankOffice().getId(), employee);

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

        employeesTable.put(employee.getId(), employee);
        bankOfficeService.addEmployee(employee.getBankOffice().getId(), employee);

        return employee;
    }

    /**
     * Получает сотрудника по ID.
     *
     * @param id ID сотрудника.
     * @return Сотрудник с указанным ID или null, если не найден.
     */
    public Employee getEmployee(Long id) {
        Employee employee = employeesTable.get(id);
        return employeesTable.get(id);
    }
}
