package tech.reliab.course.solntsevns.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.solntsevns.entity.User;
import tech.reliab.course.solntsevns.model.UserRequest;
import tech.reliab.course.solntsevns.repository.UserRepository;
import tech.reliab.course.solntsevns.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private Random random = new Random();

    public User createUser(UserRequest userRequest) {
        User user = new User(userRequest.getFullName(), userRequest.getDateOfBirth(),
                userRequest.getWorkplace(), userRequest.getMonthlyIncome(), userRequest.getCreditScore());
        user.setMonthlyIncome(generateRandomIncome());
        user.setCreditScore(calculateCreditScore(user.getMonthlyIncome()));
        return userRepository.save(user);
    }

    private double generateRandomIncome() {
        return random.nextDouble() * 10000;
    }

    private int calculateCreditScore(double income) {
        if (income < 1000) {
            return 100;
        } else if (income < 2000) {
            return 200;
        } else if (income < 3000) {
            return 300;
        } else if (income < 4000) {
            return 400;
        } else if (income < 5000) {
            return 500;
        } else if (income < 6000) {
            return 600;
        } else if (income < 7000) {
            return 700;
        } else if (income < 8000) {
            return 800;
        } else if (income < 9000) {
            return 900;
        } else {
            return 1000; // Для дохода 10 000
        }
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User was not found"));
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}