package tech.reliab.course.solntsevns.service;

import tech.reliab.course.solntsevns.entity.User;
import tech.reliab.course.solntsevns.model.UserRequest;

import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);

    User getUser(int id);

    void deleteUser(int id);

    List<User> getAllUsers();
}