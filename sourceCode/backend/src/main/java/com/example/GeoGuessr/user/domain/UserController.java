package com.example.GeoGuessr.user.domain;

import com.example.GeoGuessr.user.dto.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
record UserController(UserService userService) {

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserByID(@PathVariable UUID id) throws EntityNotFoundException {
        return userService.getUserByID(id);
    }
}
