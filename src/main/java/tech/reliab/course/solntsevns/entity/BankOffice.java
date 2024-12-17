package tech.reliab.course.solntsevns.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_offices")
public class BankOffice {
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

    @Column(nullable = false)
    private boolean canPlaceAtm;

    @Column(nullable = false)
    private boolean canOfferLoan;

    @Column(nullable = false)
    private boolean canDispenseCash;

    @Column(nullable = false)
    private boolean canDepositCash;

    @Column(nullable = false)
    private double amountOfMoney;

    @Column(nullable = false)
    private double rentCost;

    @OneToMany(mappedBy = "bankOffice")
    private List<Employee> employees;

    @OneToMany(mappedBy = "bankOffice")
    private List<BankAtm> atms;

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
    }
}