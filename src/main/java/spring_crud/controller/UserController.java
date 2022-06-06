package spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import spring_crud.model.User;
import spring_crud.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String startPage() {
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String createUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createUser";
    }

    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
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
