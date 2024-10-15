package web.service;

import web.model.User;

import java.util.List;

public interface UsersService {
    void createUser(String name, String secondName, int age);

    void updateUser(String name, String secondName, int age);

    void deleteUser(String name);

    User readUser(String name);

    List<User> getAllUsers();
}
