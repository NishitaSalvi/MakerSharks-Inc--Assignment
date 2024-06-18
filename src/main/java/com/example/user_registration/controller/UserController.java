package com.example.user_registration.controller;

import com.example.user_registration.entity.User;
import com.example.user_registration.exception.RegistrationException;
import com.example.user_registration.exception.UserNotFoundException;
import com.example.user_registration.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            if (registeredUser != null) {
                return ResponseEntity.ok("User registered successfully");
            } else {
                throw new RegistrationException("User registration failed");
            }
        } catch (Exception ex) {
            throw new RegistrationException("Failed to register user: " + ex.getMessage());
        }
    }

    @GetMapping("/fetch")
    public ResponseEntity<User> fetchUser(@RequestParam String username) {
        try {
            Optional<User> user = userService.fetchUserByUsername(username);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                throw new UserNotFoundException("User not found with username: " + username);
            }
        } catch (UserNotFoundException ex) {
            throw ex; 
        } catch (Exception ex) {
            throw new RuntimeException("Failed to fetch user: " + ex.getMessage());
        }
    }
}


