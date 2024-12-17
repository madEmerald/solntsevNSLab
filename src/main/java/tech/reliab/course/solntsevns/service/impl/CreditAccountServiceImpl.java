package tech.reliab.course.solntsevns.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.solntsevns.entity.Bank;
import tech.reliab.course.solntsevns.entity.CreditAccount;
import tech.reliab.course.solntsevns.model.CreditAccountRequest;
import tech.reliab.course.solntsevns.repository.CreditAccountRepository;
import tech.reliab.course.solntsevns.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CreditAccountServiceImpl implements CreditAccountService {
    private final CreditAccountRepository creditAccountRepository;
    private final BankService bankService;
    private final UserService userService;
    private final EmployeeService employeeService;
    private final PaymentAccountService paymentAccountService;

    public CreditAccount createCreditAccount(CreditAccountRequest creditAccountRequest) {
        CreditAccount creditAccount = new CreditAccount(userService.getUser(creditAccountRequest.getUserId()),
                bankService.getBank(creditAccountRequest.getBankId()), creditAccountRequest.getStartDate(),
                creditAccountRequest.getEndDate(), creditAccountRequest.getNumberOfMonths(),
                creditAccountRequest.getLoanAmount(), creditAccountRequest.getMonthlyPayment(),
                creditAccountRequest.getInterestRate(),
                employeeService.getEmployee(creditAccountRequest.getEmployeeId()),
                paymentAccountService.getPaymentAccount(creditAccountRequest.getPaymentAccountId()));
        return creditAccountRepository.save(creditAccount);
    }

    public CreditAccount getCreditAccount(int id) {
        return creditAccountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("CreditAccount was not found"));
    }

    public void deleteCreditAccount(int id) {
        creditAccountRepository.deleteById(id);
    }

    public List<CreditAccount> getAllCreditAccounts() {
        return creditAccountRepository.findAll();
    }
}