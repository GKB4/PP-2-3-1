package web.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class User {
    private static int id_temp;
    private int id;
    private String name;
    private String secondName;
    private int age;
    private static List<User> usersList = new ArrayList<>();

    public User() {
    }

    public User(String name, String secondName, int age) {
        this.id = id_temp++;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<User> getUsersList() {
        return usersList;
    }

    public static void setUsersList(List<User> usersList) {
        User.usersList = usersList;
    }

    public static void addUser(int id, String name, String secondName, int age) {
        usersList.add(new User(name, secondName, age));
    }
}
