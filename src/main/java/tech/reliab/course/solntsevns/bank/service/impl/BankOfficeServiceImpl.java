package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.BankAtm;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.entity.Employee;
import tech.reliab.course.solntsevns.bank.service.BankOfficeService;
import tech.reliab.course.solntsevns.bank.service.BankService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankOfficeServiceImpl implements BankOfficeService {
    private final BankService bankService;
    private final Map<Long, BankOffice> bankOfficesTable = new HashMap<>();
    private final Map<Long, List<Employee>> employeesByOfficeIdTable = new HashMap<>();
    private final Map<Long, List<BankAtm>> atmsByOfficeIdTable = new HashMap<>();

    public BankOfficeServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    /**
     * Создает новый банковский офис.
     *
     * @param name            название офиса
     * @param address         адрес офиса
     * @param bank            банк, которому принадлежит офис
     * @param canPlaceAtm     возможность размещения банкомата
     * @param canOfferLoan    возможность оформления кредита
     * @param canDispenseCash возможность выдачи денег
     * @param canDepositCash  возможность внесения денег
     * @param amountOfMoney   количество денег в офисе
     * @param rentCost        стоимость аренды
     * @return созданный BankOfficeEntity
     */
    public BankOffice createOffice(String name, String address, Bank bank, boolean canPlaceAtm, boolean canOfferLoan, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double rentCost) {
        BankOffice office = new BankOffice(name, address, bank, canPlaceAtm, canOfferLoan, canDispenseCash, canDepositCash, amountOfMoney, rentCost);
        bankOfficesTable.put(office.getId(), office);
        employeesByOfficeIdTable.put(office.getId(), new ArrayList<>());
        atmsByOfficeIdTable.put(office.getId(), new ArrayList<>());
        bankService.addOffice(office.getBank().getId(), office);

        return office;
    }

    /**
     * Получает банковский офис по ID.
     *
     * @param id идентификатор офиса
     * @return найденный BankOfficeEntity
     */
    public BankOffice getOfficeById(Long id) {
        return bankOfficesTable.get(id);
    }


    /**
     * Обновляет информацию о банковском офисе.
     *
     * @param office обновленный BankOfficeEntity
     */
    public void updateOffice(BankOffice office) {
        office.setStatus(determineStatus(office));
        office.setCanOfferLoan(office.getStatus() == "WORKING");
        office.setCanDispenseCash(office.getStatus() == "WORKING");
        office.setCanDepositCash(office.getStatus() != "NOT_WORKING");
    }

    /**
     * Добавляет банкомат в офис.
     *
     * @param officeId id банковского офиса
     * @param atm банкомат
     */
    public void addAtm(Long officeId, BankAtm atm) {
        BankOffice office = getOfficeById(officeId);
        if (office.isCanPlaceAtm()) {
            office.addATM();
            office.getBank().addAtm();

            atm.setOffice(office);
            atm.setBank(office.getBank());
            atm.setAddress(office.getAddress());

            List<BankAtm> officeAtms = atmsByOfficeIdTable.get(office.getId());
            officeAtms.add(atm);
        }
    }

    /**
     * Удаляет банкомат из офиса
     *
     * @param officeId id банковского офиса
     * @param atm банкомат
     */
    public void deleteAtm(Long officeId, BankAtm atm) {
        BankOffice office = getOfficeById(officeId);
        int atmIndex = atmsByOfficeIdTable.get(officeId).indexOf(atm);
        office.getBank().removeAtm();
        office.removeAtm();
        atmsByOfficeIdTable.get(officeId).remove(atmIndex);

        atm.setOffice(null);
    }

    /**
     * Добавить сотрудника в офис.
     * @param officeId id офиса
     * @param employee сотрудник
     */
    public void addEmployee(Long officeId, Employee employee) {
        BankOffice office = getOfficeById(officeId);
        office.addEmployee();

        employee.setBankOffice(office);
        employee.setBank(office.getBank());
        List<Employee> officeEmployees = employeesByOfficeIdTable.get(office.getId());
        officeEmployees.add(employee);
    }

    /**
     * Удаляет указанного сотрудника из офиса.
     *
     * @param officeId id офиса
     * @param employee сотрудник
     */
    public void deleteEmployee(Long officeId, Employee employee) {
        BankOffice office = getOfficeById(officeId);
        int employeeIndex = employeesByOfficeIdTable.get(officeId).indexOf(employee);
        office.getBank().removeEmployee();
        office.removeEmployee();
        employeesByOfficeIdTable.get(officeId).remove(employeeIndex);

        employee.setBankOffice(null);
    }

    /**
     * Обновляет количество денег в банковском офисе.
     *
     * @param office банковский офис
     * @param amount количество денег для обновления
     */
    public void updateAmountOfMoney(BankOffice office, double amount) {
        double diff = amount - office.getAmountOfMoney();
        if (diff + office.getBank().getTotalMoney() >= 0) {
            office.setAmountOfMoney(amount);
            updateOffice(office);

            office.getBank().setTotalMoney(diff + office.getBank().getTotalMoney());
        }
    }

    /**
     * Определяет статус офиса на основе количества денег.
     *
     * @param office офис
     * @return статус офиса
     */
    private String determineStatus(BankOffice office) {
        if (office.getAmountOfMoney() <= 0) {
            return "OUT_OF_MONEY";
        }
        return "WORKING";
    }
}