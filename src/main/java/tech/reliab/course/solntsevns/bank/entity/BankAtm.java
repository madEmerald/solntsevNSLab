package tech.reliab.course.solntsevns.bank.entity;

public class BankAtm {
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

    public BankOffice getOffice() {
        return office;
    }

    public Employee getServicingEmployee() {
        return servicingEmployee;
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

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setServicingEmployee(Employee servicingEmployee) {
        this.servicingEmployee = servicingEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmountOfMoney(double amount) {
        this.amountOfMoney = amount;
    }

    public void setMaintenanceCost(double cost) {
        this.maintenanceCost = cost;
    }

    public void setCanDispenseCash(boolean canDispenseCash) {
        this.canDispenseCash = canDispenseCash;
    }

    public void setCanDepositCash(boolean canDepositCash) {
        this.canDepositCash = canDepositCash;
    }
}