package tech.reliab.course.solntsevns;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.TreeMap;

import tech.reliab.course.solntsevns.bank.entity.*;
import tech.reliab.course.solntsevns.bank.service.*;
import tech.reliab.course.solntsevns.bank.service.impl.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.createBank("OmegaBank");
        System.out.println(bank);

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.createOffice("OmegaBank general office", "Moscow", bank, true, true, true, true, 30000000.0, 100000.0);
        System.out.println(bankOffice);

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.createEmployee("Ivan Bankin", LocalDate.of(2000, 1, 1), "CEO", bank, 1000000.0, true, bankOffice);
        System.out.println(employee);

        BankAtmService atmService = new BankAtmServiceImpl();
        BankAtm bankAtm = atmService.createAtm("ATM300", bank, bankOffice, employee, true, true, 100000, 7000);
        System.out.println(bankAtm);

        UserService userService = new UserServiceImpl();
        User user = userService.createUser("Igor Petrov", LocalDate.of(2007, 1, 1), "Roga i kopyta");
        System.out.println(user);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(user, bank);
        System.out.println(paymentAccount);

        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        CreditAccount creditAccount = creditAccountService.createCreditAccount(user, bank, LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1), 1000000, 5000, 50.0, employee, paymentAccount);
        System.out.println(creditAccount);
    }
}