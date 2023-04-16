package com.project.KFC.repositories;

import com.project.KFC.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRep extends JpaRepository<Review, Long> {
}
