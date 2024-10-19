package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UsersService;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "users/index";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", usersService.readUser(id));
        return "users/show";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("newUser") User user) {
        return "users/new";
    }

    @PostMapping(value = "/users")
    public String addUser(@ModelAttribute("newUser") User user) {
        usersService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        usersService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/update/{id}")
    public String viewUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", usersService.readUser(id));
        return "users/update";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user) {
        usersService.updateUser(user.getId(), user.getName(), user.getSecondName(), user.getAge());
        return "redirect:/users";
    }
}
