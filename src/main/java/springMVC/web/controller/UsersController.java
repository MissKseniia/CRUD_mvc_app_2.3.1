package springMVC.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springMVC.web.entity.User;
import springMVC.web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAllUsers(ModelMap model) {

        model.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/new")
    public String createUser(ModelMap model) {

        model.addAttribute("user", new User());
        return "createOrUpdate_user";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bd) {

        if (bd.hasErrors()) {
            return "createOrUpdate_user";
        }
        userService.addOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("userId") Long id, ModelMap model) {

        model.addAttribute("user", userService.getUserById(id));
        return "createOrUpdate_user";
    }

    @RequestMapping("/remove")
    public String removeUser(@RequestParam("userId") Long id) {

        userService.removeUser(id);
        return "redirect:/users";
    }

}
