package com.example.GeoGuessr.authentication.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RegisterRequest(
        @NotNull String username, @NotNull String password) {}
