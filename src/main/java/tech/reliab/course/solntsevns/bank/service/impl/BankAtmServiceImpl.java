package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.BankAtm;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;
import tech.reliab.course.solntsevns.bank.service.BankAtmService;


public class BankAtmServiceImpl implements BankAtmService {
    /**
     * Создает новый банкомат.
     *
     * @param name имя банкомата
     * @param bank банк, которому принадлежит банкомат
     * @param office офис, в котором находится банкомат
     * @param servicingEmployee работник, обслуживающий банкомат
     * @param canDispenseCash возможность выдачи денег
     * @param canDepositCash возможность внесения денег
     * @param amountOfMoney количество денег в банкомате
     * @param maintenanceCost стоимость обслуживания
     * @return созданный BankAtmEntity
     */
    public BankAtm createAtm(String name, Bank bank, BankOffice office, Employee servicingEmployee, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double maintenanceCost) {
        BankAtm atm = new BankAtm(name, office.getAddress(), bank, office, servicingEmployee, canDispenseCash, canDepositCash, amountOfMoney, maintenanceCost);
        atm.setStatus(determineStatus(atm)); // Установка статуса
        return atm;
    }


    /**
     * Обновляет информацию о банкомате.
     *
     * @param atm обновленный BankAtmEntity
     */
    public void updateAtm(BankAtm atm) {
        atm.setStatus(determineStatus(atm));
        atm.setCanDispenseCash(atm.getStatus() == "WORKING");
        atm.setCanDepositCash(atm.getStatus() != "NOT_WORKING");
        atm.setAddress(atm.getOffice().getAddress());
    }

    /**
     * Определяет статус банкомата на основе количества денег.
     *
     * @param atm банкомат, статус которого нужно определить
     * @return статус банкомата
     */
    private String determineStatus(BankAtm atm) {
        if (atm.getAmountOfMoney() <= 0) {
            return "OUT_OF_MONEY";
        }
        return "WORKING";
    }

    /**
     * Обновляет количество денег в банкомате.
     *
     * @param atm банкомат, в котором нужно обновить количество денег
     * @param amount количество денег для обновления
     */
    public void updateAmountOfMoney(BankAtm atm, double amount) {
        atm.setAmountOfMoney(amount);
        updateAtm(atm);
    }
}