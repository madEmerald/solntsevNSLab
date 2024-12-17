package tech.reliab.course.solntsevns.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.solntsevns.entity.Bank;
import tech.reliab.course.solntsevns.repository.BankRepository;
import tech.reliab.course.solntsevns.service.BankService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    public Bank createBank(String bankName) {
        Bank bank = new Bank(bankName);

        bank.setRating(generateRandomRating());
        bank.setTotalMoney(generateRandomMoney());
        bank.setInterestRate(calculateInterestRate(bank.getRating()));

        return bankRepository.save(bank);
    }

    public Bank getBank(int id) {
        return bankRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Bank was not found"));
    }

    public void deleteBank(int id) {
        bankRepository.deleteById(id);
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    private int generateRandomRating() {
        return (int) (Math.random() * 100);
    }

    private double generateRandomMoney() {
        return Math.random() * 1_000_000;
    }

    private double calculateInterestRate(int rating) {
        double baseRate = Math.random() * 20;
        return baseRate * (100 - rating) / 100;
    }
}