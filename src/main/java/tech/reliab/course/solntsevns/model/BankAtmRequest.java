package tech.reliab.course.solntsevns.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAtmRequest {
    private String name;
    private String address;
    private int bankId;
    private int officeId;
    private int employeeId;
    private boolean canDispenseCash;
    private boolean canDepositCash;
    private double amountOfMoney;
    private double maintenanceCost;
}