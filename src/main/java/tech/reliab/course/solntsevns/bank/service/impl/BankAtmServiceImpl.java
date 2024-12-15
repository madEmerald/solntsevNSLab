package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.BankAtm;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;
import tech.reliab.course.solntsevns.bank.service.BankAtmService;
import tech.reliab.course.solntsevns.bank.service.BankOfficeService;

import java.util.HashMap;
import java.util.Map;


public class BankAtmServiceImpl implements BankAtmService {
    private final Map<Long, BankAtm> atmsTable = new HashMap<>();
    private final BankOfficeService bankOfficeService;

    public BankAtmServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

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
        atmsTable.put(atm.getId(), atm);
        bankOfficeService.addAtm(atm.getOffice().getId(), atm);
        return atm;
    }

    /**
     * Получает банкомат по ID.
     *
     * @param id идентификатор банкомата
     * @return найденный BankAtmEntity
     */
    public BankAtm getAtm(Long id) {
        return atmsTable.get(id);
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
     * @param atm банкомат
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
     * @param atm банкомат
     * @param amount количество денег для обновления
     */
    public void updateAmountOfMoney(BankAtm atm, double amount) {
        atm.setAmountOfMoney(amount);
        updateAtm(atm);
    }
}