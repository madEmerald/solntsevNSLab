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
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private double totalMoney;

    @Column(nullable = false)
    private double interestRate;

    @OneToMany(mappedBy = "bank")
    private List<BankOffice> offices;

    @OneToMany(mappedBy = "bank")
    private List<User> users;

    @OneToMany(mappedBy = "bank")
    private List<Employee> employees;

    @OneToMany(mappedBy = "bank")
    private List<BankAtm> atms;

    public Bank(String name) {
        this.name = name;
    }
}
