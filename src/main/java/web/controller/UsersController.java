package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UsersService;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping(value = "/users")
    public String printUsers(@RequestParam(value = "count", required = false) String count, ModelMap model) {
        model.addAttribute("usersList", usersService.getAllUsers());
        return "users";
    }
}
