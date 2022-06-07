package spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestParam;
import spring_crud.model.User;
import spring_crud.service.UserService;

import javax.validation.Valid;
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
    public String createUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @GetMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createUser";
        } else {
            userService.save(user);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(Model model, @RequestParam Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("/refreshUser")
    public String refreshUser(@ModelAttribute User user) {
        userService.updateUserById(user.getId(), user);
        return "redirect:/";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

}
