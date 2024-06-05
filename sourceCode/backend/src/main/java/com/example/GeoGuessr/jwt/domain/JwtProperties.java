package com.example.GeoGuessr.jwt.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pl.edu.fizyczni.jwt")
public class JwtProperties {
    private String secretKey;
    private int expirationTimeMillis;
}
