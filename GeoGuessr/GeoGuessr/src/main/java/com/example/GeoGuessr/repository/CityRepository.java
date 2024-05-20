package com.example.GeoGuessr.repository;

import com.example.GeoGuessr.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
