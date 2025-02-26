package com.example.demoApplication.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demoApplication.demo.model.User;
import com.example.demoApplication.demo.service.UserService;

@RestController
@RequestMapping("/api/users") // Base URL
public class UserController {

    private final UserService userService;

    // ✅ Use @Autowired or Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
    User savedUser = userService.registerUser(user);
    return ResponseEntity.ok(savedUser);
}

}
