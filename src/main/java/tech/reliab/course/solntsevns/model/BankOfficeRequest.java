package tech.reliab.course.solntsevns.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankOfficeRequest {
    private String name;
    private String address;
    private int bankId;
    private boolean canPlaceAtm;
    private boolean canOfferLoan;
    private boolean canDispenseCash;
    private boolean canDepositCash;
    private double amountOfMoney;
    private double rentCost;
}