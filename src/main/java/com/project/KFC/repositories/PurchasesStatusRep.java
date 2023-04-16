package com.project.KFC.repositories;

import com.project.KFC.models.PurchasesStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesStatusRep extends JpaRepository<PurchasesStatus, Long> {
}
