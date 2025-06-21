package com.simple.ecommerce.postgres.repository;

import com.simple.ecommerce.postgres.entity.PgReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PgReviewRepository extends JpaRepository<PgReview, Long> {
    List<PgReview> findByProductId(Long productId);
}
