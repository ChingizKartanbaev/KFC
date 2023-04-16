package com.project.KFC.repositories;

import com.project.KFC.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRep extends JpaRepository<Products, Long> {
}
