package com.example.GeoGuessr.authentication.domain;

import com.example.GeoGuessr.authentication.dto.AuthRequest;
import com.example.GeoGuessr.authentication.dto.AuthResponse;
import com.example.GeoGuessr.authentication.dto.RegisterRequest;
import com.example.GeoGuessr.exception.UserAlreadyExistsException;
import com.example.GeoGuessr.jwt.JwtService;
import com.example.GeoGuessr.jwt.dto.JwtUser;
import com.example.GeoGuessr.user.UserService;
import com.example.GeoGuessr.user.dto.UserRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
record AuthService(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager)
        implements com.example.GeoGuessr.authentication.AuthService {

    @Override
    public void register(RegisterRequest req) {
        if (userService.existsByUsername(req.username())) {
            throw new UserAlreadyExistsException("User" + req.username() + " already exists!");
        }
        UserRequest userRequest = UserRequest.builder()
                .username(req.username())
                .password(req.password())
                .build();
        userService.createUser(userRequest);
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        UserDetails userDetails = userService.loadUserByUsername(request.username());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.username(), request.password(), userDetails.getAuthorities()));
        String token = jwtService().generateToken(new JwtUser(userDetails.getUsername()));
        return new AuthResponse(token);
    }
}
