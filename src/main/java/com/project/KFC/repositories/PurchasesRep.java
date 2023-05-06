package com.project.KFC.repositories;

import com.project.KFC.models.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasesRep extends JpaRepository<Purchases, Long> {
}
