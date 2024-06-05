package com.example.GeoGuessr.user;

import com.example.GeoGuessr.user.dto.UserRequest;
import com.example.GeoGuessr.user.dto.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService {

    UserResponse getUserByID(UUID id) throws EntityNotFoundException;

    List<UserResponse> getAllUsers();

    void createUser(UserRequest userRequest);

    boolean existsByUsername(String username);
}
