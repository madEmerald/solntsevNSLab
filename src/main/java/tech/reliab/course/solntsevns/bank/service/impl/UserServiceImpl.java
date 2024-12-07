package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.CreditAccount;
import tech.reliab.course.solntsevns.bank.entity.PaymentAccount;
import tech.reliab.course.solntsevns.bank.entity.User;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.service.UserService;

import java.time.LocalDate;
import java.util.Random;


public class UserServiceImpl implements UserService {
    private Random random = new Random();
    /**
     * Создает нового клиента банка со сгенерированным доходом и кредитным рейтингом.
     *
     * @param fullName ФИО клиента
     * @param dateOfBirth дата рождения
     * @param workplace место работы
     * @return созданный UserEntity
     */
    public User createUser(String fullName, LocalDate dateOfBirth, String workplace) {
        double monthlyIncome = generateRandomIncome(); // Генерация случайного дохода
        int creditScore = calculateCreditScore(monthlyIncome); // Расчет кредитного рейтинга
        User user = new User(fullName, dateOfBirth, workplace, monthlyIncome, creditScore);
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

    /**
     * Добавляет банк в список банков пользователя.
     *
     * @param user пользователь, которому добавляется банк
     * @param bank банк, который добавляется
     */
    public void addBankToUser(User user, Bank bank) {

    }

    /**
     * Добавляет кредитный счет пользователю.
     *
     * @param user пользователь, которому добавляется кредитный счет
     * @param creditAccount кредитный счет
     */
    public void addCreditAccountToUser(User user, CreditAccount creditAccount) {

    }

    /**
     * Добавляет платежный счет пользователю.
     *
     * @param user пользователь, которому добавляется платежный счет
     * @param paymentAccount платежный счет
     */
    public void addPaymentAccountToUser(User user, PaymentAccount paymentAccount) {

    }

    /**
     * Удаляет указанный банк из списка банков пользователя.
     *
     * @param user пользователь, из которого удаляется банк
     * @param bank банк, который нужно удалить из списка банков пользователя
     */
    public void deleteBankFromUser(User user, Bank bank) {

    }

    /**
     * Удаляет указанный кредитный счет из списка кредитных счетов пользователя.
     *
     * @param user пользователь, у которого удаляется кредитный счет
     * @param creditAccount кредитный счет, который нужно удалить из списка кредитных счетов пользователя
     */
    public void deleteCreditAccountFromUser(User user, CreditAccount creditAccount) {
    }

    /**
     * Удаляет указанный платежный счет из списка платежных счетов пользователя.
     *
     * @param user пользователь, у которого удаляется платежный счет
     * @param paymentAccount платежный счет, который нужно удалить из списка платежных счетов пользователя
     */
    public void deletePaymentAccountToUser(User user, PaymentAccount paymentAccount) {

    }
}