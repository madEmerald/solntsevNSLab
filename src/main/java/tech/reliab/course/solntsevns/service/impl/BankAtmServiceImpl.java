package tech.reliab.course.solntsevns.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.solntsevns.entity.Bank;
import tech.reliab.course.solntsevns.entity.BankAtm;
import tech.reliab.course.solntsevns.model.BankAtmRequest;
import tech.reliab.course.solntsevns.repository.BankAtmRepository;
import tech.reliab.course.solntsevns.service.BankAtmService;
import tech.reliab.course.solntsevns.service.BankOfficeService;
import tech.reliab.course.solntsevns.service.BankService;
import tech.reliab.course.solntsevns.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BankAtmServiceImpl implements BankAtmService {
    private final BankAtmRepository bankAtmRepository;
    private final BankService bankService;
    private final BankOfficeService bankOfficeService;
    private final EmployeeService employeeService;

    public BankAtm createBankAtm(BankAtmRequest bankAtmRequest) {
        Bank bank = bankService.getBank(bankAtmRequest.getBankId());
        BankAtm bankAtm = new BankAtm(bankAtmRequest.getName(), bankAtmRequest.getAddress(), bank,
                bankOfficeService.getOffice(bankAtmRequest.getOfficeId()),
                employeeService.getEmployee(bankAtmRequest.getEmployeeId()),
                bankAtmRequest.isCanDispenseCash(), bankAtmRequest.isCanDepositCash(),
                bankAtmRequest.getAmountOfMoney(), bankAtmRequest.getMaintenanceCost());
        bankAtm.setAmountOfMoney(new Random().nextDouble(bank.getTotalMoney()));
        updateAtm(bankAtm.getId());
        return bankAtmRepository.save(bankAtm);
    }

    public BankAtm getAtm(int id) {
        return bankAtmRepository.findById(id).orElseThrow(() -> new NoSuchElementException("BankAtm was not found"));
    }

    public BankAtm updateAtm(int id) {
        BankAtm atm = getAtm(id);
        atm.setStatus(determineStatus(atm));
        atm.setCanDispenseCash(atm.getStatus() == "WORKING");
        atm.setCanDepositCash(atm.getStatus() != "NOT_WORKING");
        atm.setAddress(atm.getOffice().getAddress());

        return atm;
    }

    private String determineStatus(BankAtm atm) {
        if (atm.getAmountOfMoney() <= 0) {
            return "OUT_OF_MONEY";
        }
        return "WORKING";
    }

    public void updateAmountOfMoney(BankAtm atm, double amount) {
        atm.setAmountOfMoney(amount);
        updateAtm(atm.getId());
    }

    public void deleteAtm(int id) {
        bankAtmRepository.deleteById(id);
    }

    public List<BankAtm> getAllBankAtms() {
        return bankAtmRepository.findAll();
    }

    public List<BankAtm> getAllBankAtmsByBankId(int bankId) {
        return bankAtmRepository.findAllByBankId(bankId);
    }
}