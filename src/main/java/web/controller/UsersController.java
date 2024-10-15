package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UsersService;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping(value = "/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("newUser") User user) {
        return "new";
    }

    @PostMapping
    public String addUser(@ModelAttribute("newUser") User user) {
        usersService.saveUser(user);
        return "redirect:/users";
    }
}
