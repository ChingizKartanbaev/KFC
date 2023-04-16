package com.project.KFC.repositories;

import com.project.KFC.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRep extends JpaRepository<Category, Long> {
}
