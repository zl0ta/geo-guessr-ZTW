package com.example.GeoGuessr.repository;

import com.example.GeoGuessr.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
}
