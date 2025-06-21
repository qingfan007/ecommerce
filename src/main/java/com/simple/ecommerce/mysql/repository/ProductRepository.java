package com.simple.ecommerce.mysql.repository;

import com.simple.ecommerce.mysql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
