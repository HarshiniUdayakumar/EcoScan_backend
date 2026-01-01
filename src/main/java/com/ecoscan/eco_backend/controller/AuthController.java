package com.ecoscan.eco_backend.controller;

import com.ecoscan.eco_backend.dto.AuthResponse;
import com.ecoscan.eco_backend.entity.User;
import com.ecoscan.eco_backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // frontend URL
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public AuthResponse registerUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return new AuthResponse("Email already exists!");
        }
        User savedUser = userRepository.save(user);
        return new AuthResponse("User registered successfully!", savedUser.getId());
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            return new AuthResponse("Login successful!", existingUser.get().getId());
        }
        return new AuthResponse("Invalid email or password!");
    }

}
