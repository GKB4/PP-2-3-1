package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

    @Override
    public void createUser(String name, String secondName, int age) {

    }

    @Override
    public void updateUser(String name, String secondName, int age) {

    }

    @Override
    public void deleteUser(String name) {

    }

    @Override
    public User readUser(String name) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        if (User.getUsersList().isEmpty()) {
            User.addUser(new User("Igor", "Ilkov", 38));
            User.addUser(new User("Sergey", "Shichkin", 45));
            User.addUser(new User("Pupok", "Pupkin", 78));
        }
        return User.getUsersList();
    }

    @Override
    public void saveUser(User user) {
        User.addUser(user);
    }
}
