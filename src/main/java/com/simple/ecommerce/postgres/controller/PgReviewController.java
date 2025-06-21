package com.simple.ecommerce.postgres.controller;

import com.simple.ecommerce.postgres.entity.PgReview;
import com.simple.ecommerce.postgres.repository.PgReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pg-reviews")
public class PgReviewController {

    @Autowired
    private PgReviewRepository pgReviewRepository;

    @GetMapping
    public List<PgReview> getAll() {
        return pgReviewRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public List<PgReview> getByProductId(@PathVariable Long id) {
        return pgReviewRepository.findByProductId(id);
    }

    @PostMapping
    public PgReview create(@RequestBody PgReview review) {
        return pgReviewRepository.save(review);
    }

}
