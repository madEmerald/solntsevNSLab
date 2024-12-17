package tech.reliab.course.solntsevns.service;

import tech.reliab.course.solntsevns.entity.CreditAccount;
import tech.reliab.course.solntsevns.model.CreditAccountRequest;

import java.util.List;

public interface CreditAccountService {
    CreditAccount createCreditAccount(CreditAccountRequest creditAccountRequest);

    CreditAccount getCreditAccount(int id);

    void deleteCreditAccount(int id);

    List<CreditAccount> getAllCreditAccounts();
}


