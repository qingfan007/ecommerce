package com.simple.ecommerce.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pg_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PgReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private String username;

    private String content;

    private int rating; // e.g., 1~5 stars

}
