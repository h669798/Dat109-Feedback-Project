package org.example.demo.controller;

import org.example.demo.model.Admin;
import org.example.demo.model.Lecturer;
import org.example.demo.model.User;
import org.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Registrer bruker (kun admin og foreleser)
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        if (!(user instanceof Admin || user instanceof Lecturer)) {
            throw new UnauthorizedAccessException("Kun admin og forelesere kan registrere brukere.");
        }
        return userService.registerUser(user);
    }

    // Logge inn som bruker (kun admin og foreleser)
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        if (!(user instanceof Admin || user instanceof Lecturer)) {
            throw new UnauthorizedAccessException("Kun admin og forelesere kan logge inn.");
        }
        return userService.loginUser(user);
    }

    @GetMapping("/{id}")
    public User getUserProfile(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
