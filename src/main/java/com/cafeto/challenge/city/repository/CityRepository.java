package com.cafeto.challenge.city.repository;

import com.cafeto.challenge.city.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
