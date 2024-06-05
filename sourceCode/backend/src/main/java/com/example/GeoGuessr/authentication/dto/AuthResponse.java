package com.example.GeoGuessr.authentication.dto;

import lombok.Builder;

@Builder
public record AuthResponse(String token) {}
