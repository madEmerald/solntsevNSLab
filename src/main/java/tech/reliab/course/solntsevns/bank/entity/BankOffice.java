package tech.reliab.course.solntsevns.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankOffice {
    private static Long currentId = 0L;
    private Long id;

    private String name;

    private String address;
    private String status;
    private Bank bank;
    private boolean canPlaceAtm;
    private int numberOfATMs;
    private int numberOfEmployees;
    private boolean canOfferLoan;
    private boolean canDispenseCash;
    private boolean canDepositCash;
    private double amountOfMoney;
    private double rentCost;

    public BankOffice(String name, String address, Bank bank, boolean canPlaceAtm, boolean canOfferLoan, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double rentCost) {
        this.id = currentId++;

        this.name = name;
        this.address = address;
        this.bank = bank;
        this.status ="NOT_WORKING";
        this.canPlaceAtm = canPlaceAtm;
        this.canOfferLoan = canOfferLoan;
        this.canDispenseCash = canDispenseCash;
        this.canDepositCash = canDepositCash;
        this.amountOfMoney = amountOfMoney;
        this.rentCost = rentCost;
        this.numberOfATMs = 0;
    }

    public void addATM() {
        this.numberOfATMs++;
    }

    public void removeAtm() {
        this.numberOfATMs--;
    }

    public void addEmployee() {
        this.numberOfEmployees++;
    }

    public void removeEmployee() {
        this.numberOfEmployees--;
    }
}