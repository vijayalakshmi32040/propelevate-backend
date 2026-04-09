package com.propelevate.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.propelevate.backend.dto.LoginRequest;
import com.propelevate.backend.dto.SignupRequest;
import com.propelevate.backend.entity.User;
import com.propelevate.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    // SIGNUP API
    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest request) {
        if (userService.userExists(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return userService.registerUser(user);
    }

    // LOGIN API
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return userService.loginUser(request.getEmail(), request.getPassword())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));
    }

    // UPDATE USER ROLE API
    @PutMapping("/update-role")
    public User updateUserRole(@RequestParam String email, @RequestParam String role) {
        return userService.updateUserRole(email, role);
    }

}