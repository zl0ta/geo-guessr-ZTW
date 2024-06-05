package com.example.GeoGuessr.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserRequest(
        @NotNull String username, @NotNull String password) {}
