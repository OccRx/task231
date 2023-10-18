package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/")
    public ModelAndView printUser(ModelAndView modelAndView) {
        modelAndView.addObject("userList", userService.findAll());
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }

    @GetMapping(value = "/saveUser")
    public String saveUserForm(Model model) {
        model.addAttribute("newUser", new User());
        return "saveUserForm";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("newUser") User newUser) {
        userService.add(newUser);
        return "redirect:/";
    }

    @GetMapping(value = "/updateUser")
    public String updateUserForm(@RequestParam(value = "id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "updateUserForm";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}