package com.example.GeoGuessr.authentication.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AuthRequest(@NotNull String username, @NotNull String password) {}
