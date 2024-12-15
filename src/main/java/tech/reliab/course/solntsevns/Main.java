package tech.reliab.course.solntsevns;

import java.time.LocalDate;
import java.util.Locale;

import tech.reliab.course.solntsevns.bank.entity.*;
import tech.reliab.course.solntsevns.bank.service.*;
import tech.reliab.course.solntsevns.bank.service.impl.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.createBank("OmegaBank");
        System.out.println(bank);

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
        BankOffice bankOffice = bankOfficeService.createOffice("OmegaBank general office", "Moscow", bank, true, true, true, true, 30000000.0, 100000.0);
        System.out.println(bankOffice);

        EmployeeService employeeService = new EmployeeServiceImpl(bankOfficeService);
        Employee employee = employeeService.createEmployee("Ivan Bankin", LocalDate.of(2000, 1, 1), "CEO", bank, 1000000.0, true, bankOffice);
        System.out.println(employee);

        BankAtmService atmService = new BankAtmServiceImpl(bankOfficeService);
        BankAtm bankAtm = atmService.createAtm("ATM300", bank, bankOffice, employee, true, true, 100000, 7000);
        System.out.println(bankAtm);

        UserService userService = new UserServiceImpl(bankService);
        User user = userService.createUser("Igor Petrov", LocalDate.of(2007, 1, 1), bank, "Roga i kopyta");
        System.out.println(user);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(userService);
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(user, bank);
        System.out.println(paymentAccount);

        CreditAccountService creditAccountService = new CreditAccountServiceImpl(userService);
        CreditAccount creditAccount = creditAccountService.createCreditAccount(user, bank, LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1), 1000000, 5000, 50.0, employee, paymentAccount);
        System.out.println(creditAccount);
    }
}