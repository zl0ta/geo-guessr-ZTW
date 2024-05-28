package com.example.GeoGuessr.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/login")
    public ResponseEntity<String> login(RegisterAndLoginRequest loginRequest) {
        return ResponseEntity.ok("");
    }

    @GetMapping("/register")
    public ResponseEntity<String> showRegisterPage(RegisterAndLoginRequest registerRequest) {
        return ResponseEntity.ok("");
    }



}
