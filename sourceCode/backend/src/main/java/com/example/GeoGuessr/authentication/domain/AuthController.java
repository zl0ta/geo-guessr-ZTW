package com.example.GeoGuessr.authentication.domain;

import com.example.GeoGuessr.authentication.dto.AuthRequest;
import com.example.GeoGuessr.authentication.dto.AuthResponse;
import com.example.GeoGuessr.authentication.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public record AuthController(AuthService authService) {
    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest registerRequest) {
        authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse authenticate(@RequestBody @Valid AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}
