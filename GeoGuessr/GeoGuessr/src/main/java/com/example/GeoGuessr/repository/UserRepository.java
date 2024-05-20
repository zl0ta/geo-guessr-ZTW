package com.example.GeoGuessr.repository;

import com.example.GeoGuessr.model.Room;
import com.example.GeoGuessr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
