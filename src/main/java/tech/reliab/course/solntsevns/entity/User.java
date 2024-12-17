package tech.reliab.course.solntsevns.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String workplace;

    @Column(nullable = false)
    private double monthlyIncome;

    @Column(nullable = false)
    private int creditScore;

    @ManyToMany
    @JoinTable(
            name = "user_banks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id")
    )
    private List<Bank> banks;

    @OneToMany(mappedBy = "user")
    private List<CreditAccount> creditAccounts;

    @OneToMany(mappedBy = "user")
    private List<PaymentAccount> paymentAccounts;

    public User(String fullName, LocalDate dateOfBirth, String workplace, double monthlyIncome, int creditScore) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.workplace = workplace;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
    }
}
