package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public void createUser(String name, String secondName, int age) {
        userDAO.create(name, secondName, age);
    }

    @Transactional
    @Override
    public void updateUser(int id, String name, String secondName, int age) {
        userDAO.update(id, name, secondName, age);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    @Transactional
    @Override
    public User readUser(int id) {
        return userDAO.read(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.readUsers();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDAO.create(user);
    }
}
