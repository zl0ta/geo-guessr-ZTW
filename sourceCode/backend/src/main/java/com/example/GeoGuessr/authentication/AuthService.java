package com.example.GeoGuessr.authentication;

import com.example.GeoGuessr.authentication.dto.AuthRequest;
import com.example.GeoGuessr.authentication.dto.AuthResponse;
import com.example.GeoGuessr.authentication.dto.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest req);

    AuthResponse authenticate(AuthRequest request);
}
