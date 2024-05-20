package com.example.GeoGuessr.repository;

import com.example.GeoGuessr.model.PlayerResult;
import com.example.GeoGuessr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerResultRepository extends JpaRepository<PlayerResult, Long> {
}
