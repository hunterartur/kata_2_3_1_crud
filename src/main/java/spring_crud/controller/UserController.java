package spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import spring_crud.model.Sex;
import spring_crud.model.User;
import spring_crud.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String startPage(ModelMap model) {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            model.addAttribute("users", users);
        }
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String createUser() {
        return "createUser";
    }

    @GetMapping("/saveUser")
    public String saveUser(@RequestParam String name, @RequestParam String lastname,
                           @RequestParam byte age, @RequestParam String hobby,
                           @RequestParam(defaultValue = "Man") String sex) {
        User user = new User(name, lastname, age, hobby, (sex.equals("Woman")) ? Sex.Woman : Sex.Man);
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser() {
        return "updateUser";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser() {
        return "deleteUser";
    }

    @GetMapping(value = "/readUser")
    public String readUser() {
        return "readUser";
    }
}
