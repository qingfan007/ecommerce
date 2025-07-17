package com.simple.ecommerce.mysql.repository;

import com.simple.ecommerce.mysql.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
