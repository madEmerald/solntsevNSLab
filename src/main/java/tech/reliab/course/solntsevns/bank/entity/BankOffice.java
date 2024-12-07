package tech.reliab.course.solntsevns.bank.entity;

public class BankOffice {
    private Long id;

    private String name;
    private String address;
    private String status;
    private Bank bank;
    private boolean canPlaceAtm;
    private int numberOfATMs;
    private boolean canOfferLoan;
    private boolean canDispenseCash;
    private boolean canDepositCash;
    private double amountOfMoney;
    private double rentCost;

    public BankOffice(String name, String address, Bank bank, boolean canPlaceAtm, boolean canOfferLoan, boolean canDispenseCash, boolean canDepositCash, double amountOfMoney, double rentCost) {
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public Bank getBank() {
        return bank;
    }

    public boolean isCanPlaceAtm() {
        return canPlaceAtm;
    }

    public int getNumberOfATMs() {
        return numberOfATMs;
    }

    public boolean isCanOfferLoan() {
        return canOfferLoan;
    }

    public boolean isCanDispenseCash() {
        return canDispenseCash;
    }

    public boolean isCanDepositCash() {
        return canDepositCash;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCanPlaceAtm(boolean canPlaceAtm) {
        this.canPlaceAtm = canPlaceAtm;
    }

    public void setCanOfferLoan(boolean canOfferLoan) {
        this.canOfferLoan = canOfferLoan;
    }

    public void setCanDispenseCash(boolean canDispenseCash) {
        this.canDispenseCash = canDispenseCash;
    }

    public void setCanDepositCash(boolean canDepositCash) {
        this.canDepositCash = canDepositCash;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public void addATM() {
        this.numberOfATMs++;
    }

    public void removeAtm() {
        this.numberOfATMs--;
    }
}