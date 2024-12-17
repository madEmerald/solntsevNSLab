package tech.reliab.course.solntsevns.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.solntsevns.entity.Bank;
import tech.reliab.course.solntsevns.entity.BankOffice;
import tech.reliab.course.solntsevns.model.BankOfficeRequest;
import tech.reliab.course.solntsevns.repository.BankOfficeRepository;
import tech.reliab.course.solntsevns.service.BankOfficeService;
import tech.reliab.course.solntsevns.service.BankService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BankOfficeServiceImpl implements BankOfficeService {
    private final BankOfficeRepository bankOfficeRepository;
    private final BankService bankService;

    public BankOffice createBankOffice(BankOfficeRequest bankOfficeRequest) {
        Bank bank = bankService.getBank(bankOfficeRequest.getBankId());
        BankOffice bankOffice = new BankOffice(bankOfficeRequest.getName(), bankOfficeRequest.getAddress(), bank,
                bankOfficeRequest.isCanPlaceAtm(), bankOfficeRequest.isCanOfferLoan(),
                bankOfficeRequest.isCanDispenseCash(), bankOfficeRequest.isCanDepositCash(),
                bankOfficeRequest.getAmountOfMoney(), bankOfficeRequest.getRentCost());
        bankOffice.setAmountOfMoney(new Random().nextDouble(bank.getTotalMoney()));
        updateOffice(bankOffice.getId());
        return bankOfficeRepository.save(bankOffice);
    }

    public BankOffice getOffice(int id) {
        return bankOfficeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("BankOffice was not found"));
    }

    public BankOffice updateOffice(int id) {
        BankOffice office = getOffice(id);
        office.setStatus(determineStatus(office));
        office.setCanOfferLoan(office.getStatus() == "WORKING");
        office.setCanDispenseCash(office.getStatus() == "WORKING");
        office.setCanDepositCash(office.getStatus() != "NOT_WORKING");

        return office;
    }

    public void updateAmountOfMoney(BankOffice office, double amount) {
        double diff = amount - office.getAmountOfMoney();
        if (diff + office.getBank().getTotalMoney() >= 0) {
            office.setAmountOfMoney(amount);
            updateOffice(office.getId());

            office.getBank().setTotalMoney(diff + office.getBank().getTotalMoney());
        }
    }

    private String determineStatus(BankOffice office) {
        if (office.getAmountOfMoney() <= 0) {
            return "OUT_OF_MONEY";
        }
        return "WORKING";
    }

    public void deleteOffice(int id) {
        bankOfficeRepository.deleteById(id);
    }

    public List<BankOffice> getAllBankOffices() {
        return bankOfficeRepository.findAll();
    }

}