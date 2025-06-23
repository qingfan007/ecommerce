package com.simple.ecommerce.postgres.controller;

import com.simple.ecommerce.postgres.entity.PgReview;
import com.simple.ecommerce.postgres.repository.PgReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pg-reviews")
public class PgReviewController {

    @Autowired
    private PgReviewRepository pgReviewRepository;

    @GetMapping
    public Page<PgReview> getAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return pgReviewRepository.findAll(pageable);
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
