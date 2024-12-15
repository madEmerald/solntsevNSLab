package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.*;
import tech.reliab.course.solntsevns.bank.service.BankService;
import tech.reliab.course.solntsevns.bank.service.UserService;

import java.time.LocalDate;
import java.util.*;


public class UserServiceImpl implements UserService {
    private Random random = new Random();
    private final Map<Long, User> usersTable = new HashMap<>();
    private final Map<Long, List<PaymentAccount>> paymentAccountsByUserIdTable = new HashMap<>();
    private final Map<Long, List<CreditAccount>> creditAccountsByUserIdTable = new HashMap<>();
    private final BankService bankService;

    public UserServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    /**
     * Создает нового клиента банка со сгенерированным доходом и кредитным рейтингом.
     *
     * @param fullName ФИО клиента
     * @param dateOfBirth дата рождения
     * @param workplace место работы
     * @return созданный UserEntity
     */
    public User createUser(String fullName, LocalDate dateOfBirth, Bank bank, String workplace) {
        double monthlyIncome = generateRandomIncome(); // Генерация случайного дохода
        int creditScore = calculateCreditScore(monthlyIncome); // Расчет кредитного рейтинга
        User user = new User(fullName, dateOfBirth, bank, workplace, monthlyIncome, creditScore);

        usersTable.put(user.getId(), user);
        paymentAccountsByUserIdTable.put(user.getId(), new ArrayList<>());
        creditAccountsByUserIdTable.put(user.getId(), new ArrayList<>());
        bankService.addUser(user.getBank().getId(), user);

        return user;
    }

    /**
     * Генерирует случайный ежемесячный доход до 10 000.
     *
     * @return сгенерированный доход
     */
    private double generateRandomIncome() {
        return random.nextDouble() * 10000; // Генерация случайного дохода до 10 000
    }

    /**
     * Рассчитывает кредитный рейтинг на основе ежемесячного дохода.
     *
     * @param income ежемесячный доход
     * @return кредитный рейтинг
     */
    private int calculateCreditScore(double income) {
        if (income < 1000) {
            return 100;
        } else if (income < 2000) {
            return 200;
        } else if (income < 3000) {
            return 300;
        } else if (income < 4000) {
            return 400;
        } else if (income < 5000) {
            return 500;
        } else if (income < 6000) {
            return 600;
        } else if (income < 7000) {
            return 700;
        } else if (income < 8000) {
            return 800;
        } else if (income < 9000) {
            return 900;
        } else {
            return 1000; // Для дохода 10 000
        }
    }

    public User getUser(Long id) {
        return usersTable.get(id);
    }

    /**
     * Добавляет кредитный счет пользователю.
     *
     * @param userId пользователя
     * @param creditAccount кредитный счет
     */
    public void addCreditAccount(Long userId, CreditAccount creditAccount) {
        List<CreditAccount> clientCreditAccounts = creditAccountsByUserIdTable.get(userId);
        creditAccount.setUser(getUser(userId));
        clientCreditAccounts.add(creditAccount);
    }

    /**
     * Добавляет платежный счет пользователю.
     *
     * @param userId пользователя
     * @param paymentAccount платежный счет
     */
    public void addPaymentAccount(Long userId, PaymentAccount paymentAccount) {
        List<PaymentAccount> clientCreditAccounts = paymentAccountsByUserIdTable.get(userId);
        paymentAccount.setUser(getUser(userId));
        clientCreditAccounts.add(paymentAccount);
    }

    /**
     * Удаляет указанный кредитный счет из списка кредитных счетов пользователя.
     *
     * @param userId пользователя
     * @param creditAccount кредитный счет
     */
    public void deleteCreditAccount(Long userId, CreditAccount creditAccount) {
        creditAccount.setUser(null);
        creditAccountsByUserIdTable.get(userId).remove(creditAccount);
    }

    /**
     * Удаляет указанный платежный счет из списка платежных счетов пользователя.
     *
     * @param userId пользователя
     * @param paymentAccount платежный счет
     */
    public void deletePaymentAccount(Long userId, PaymentAccount paymentAccount) {
        paymentAccount.setUser(null);
        paymentAccountsByUserIdTable.get(userId).remove(paymentAccount);
    }
}