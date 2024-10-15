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
        User.setUsersList(List.of(new User ("Igor", "Ilkov", 38),
                new User("Sergey", "Shichkin", 45),
                new User ("Pupok", "Pupkin", 78)));
        return User.getUsersList();
    }
}
