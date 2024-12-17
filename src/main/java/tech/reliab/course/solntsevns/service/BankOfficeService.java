package tech.reliab.course.solntsevns.service;

import tech.reliab.course.solntsevns.entity.BankOffice;
import tech.reliab.course.solntsevns.model.BankOfficeRequest;

import java.util.List;

public interface BankOfficeService {
    BankOffice createBankOffice(BankOfficeRequest bankOfficeRequest);

    BankOffice getOffice(int id);

    BankOffice updateOffice(int id);

    void updateAmountOfMoney(BankOffice office, double amount);

    void deleteOffice(int id);

    List<BankOffice> getAllBankOffices();
}