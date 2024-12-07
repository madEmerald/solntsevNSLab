package tech.reliab.course.solntsevns.bank.service.impl;

import tech.reliab.course.solntsevns.bank.entity.BankAtm;
import tech.reliab.course.solntsevns.bank.entity.Bank;
import tech.reliab.course.solntsevns.bank.entity.BankOffice;
import tech.reliab.course.solntsevns.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
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
        return office;
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
     * Увеличивает количество банкоматов в офисе.
     *
     * @param office банковский офис, в котором нужно увеличить количество банкоматов
     */
    public void addAtmToOffice(BankOffice office, BankAtm atm) {
        if (office.isCanPlaceAtm() && office.getBank() == atm.getBank()) {
            office.addATM();
            updateOffice(office);

            atm.setOffice(office);
        }
    }

    /**
     * Уменьшает количество банкоматов в офисе.
     *
     * @param office банковский офис, в котором нужно уменьшить количество банкоматов
     */
    public void removeAtmFromOffice(BankOffice office, BankAtm atm) {
        office.removeAtm();
        updateOffice(office);

        atm.setOffice(null);
    }

    /**
     * Обновляет количество денег в банковском офисе.
     *
     * @param office банковский офис, в котором нужно обновить количество денег
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
     * @param office офис, статус которого нужно определить
     * @return статус офиса
     */
    private String determineStatus(BankOffice office) {
        if (office.getAmountOfMoney() <= 0) {
            return "OUT_OF_MONEY";
        }
        return "WORKING";
    }
}