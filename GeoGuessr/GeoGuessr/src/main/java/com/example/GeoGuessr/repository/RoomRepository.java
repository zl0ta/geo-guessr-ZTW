package com.example.GeoGuessr.repository;

import com.example.GeoGuessr.model.City;
import com.example.GeoGuessr.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
