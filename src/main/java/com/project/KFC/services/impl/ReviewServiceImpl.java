package com.project.KFC.services.impl;

import com.project.KFC.models.Review;
import com.project.KFC.repositories.ReviewRep;
import com.project.KFC.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRep rep;

    @Autowired
    public ReviewServiceImpl(ReviewRep rep) {
        this.rep = rep;
    }

    @Override
    public Review save(Review t) {
        return rep.save(t);
    }

    @Override
    public Review findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Review update(Long id, Review review) {
        return null;
    }

    @Override
    public List<Review> findAll() {
        return rep.findAll();
    }
}
