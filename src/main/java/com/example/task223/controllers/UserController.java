package com.example.task223.controllers;

import com.example.task223.entities.User;
import com.example.task223.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
 public class UserController {
    private UserRepository userRepository;

    public UserController(){}
    @GetMapping
    public String showUsers(Model model) {
        List<User> users = userRepository.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.getUserById(id));
        return "user";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userRepository.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userRepository.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteUser(id);
        return "redirect:/users";
    }
}