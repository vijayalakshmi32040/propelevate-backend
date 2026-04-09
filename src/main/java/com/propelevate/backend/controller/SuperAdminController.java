package com.propelevate.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.propelevate.backend.entity.User;
import com.propelevate.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/superadmin")
@CrossOrigin("*")
public class SuperAdminController {

    @Autowired
    private UserRepository userRepository;

    // Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

}