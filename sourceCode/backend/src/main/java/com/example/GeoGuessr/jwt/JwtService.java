package com.example.GeoGuessr.jwt;

import com.example.GeoGuessr.jwt.dto.JwtUser;
import io.jsonwebtoken.Claims;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {
    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    boolean isTokenValid(String token, JwtUser user);

    String generateToken(JwtUser user);

    String generateToken(Map<String, Object> extraClaims, JwtUser user);
}
