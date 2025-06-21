package com.simple.ecommerce.mysql.repository;

import com.simple.ecommerce.mysql.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
