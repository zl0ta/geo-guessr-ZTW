package com.example.GeoGuessr.user.domain;

import com.example.GeoGuessr.user.dto.UserRequest;
import com.example.GeoGuessr.user.dto.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.val;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
record UserService(UserRepository userRepository, UserMapper userMapper)
        implements com.example.GeoGuessr.user.UserService {

    @Override
    public UserResponse getUserByID(UUID id) throws EntityNotFoundException {
        return userMapper.userToUserResponse(userRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserResponse)
                .collect(toList());
    }

    @Override
    public void createUser(UserRequest userRequest) {
        val user = userMapper.userRequestToUser(userRequest);
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
