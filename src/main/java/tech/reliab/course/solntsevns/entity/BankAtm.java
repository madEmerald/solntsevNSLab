package tech.reliab.course.solntsevns.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_atms")
public class BankAtm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private BankOffice office;

    @ManyToOne
    private Employee servicingEmployee;

    @Column(nullable = false)
    private boolean canDispenseCash;

    @Column(nullable = false)
    private boolean canDepositCash;

    @Column(nullable = false)
    private double amountOfMoney;

    @Column(nullable = false)
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
}