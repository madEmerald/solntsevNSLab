package tech.reliab.course.solntsevns.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankAtm {
    private static Long currentId = 0L;
    private Long id;

    private String name;
    private String address;
    private String status;

    private Bank bank;
    private BankOffice office;
    private Employee servicingEmployee;

    private boolean canDispenseCash;
    private boolean canDepositCash;
    private double amountOfMoney;
    private double maintenanceCost;

    public BankAtm(String name, String address, Bank bank, BankOffice office, Employee servicingEmployee, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double maintenanceCost) {
        this.id = currentId++;

        this.name = name;
        this.address = address;
        this.bank = bank;
        this.office = office;
        this.servicingEmployee = servicingEmployee;

        this.canDispenseCash = canDispenseCash;
        this.canDepositCash = canDepositCash;
        this.amountOfMoney = amountOfMoney;
        this.maintenanceCost = maintenanceCost;
        this.status = "NOT_WORKING";
    }
}