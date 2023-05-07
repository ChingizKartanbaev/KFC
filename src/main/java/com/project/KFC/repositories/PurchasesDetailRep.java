package com.project.KFC.repositories;

import com.project.KFC.models.Purchases;
import com.project.KFC.models.PurchasesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasesDetailRep extends JpaRepository<PurchasesDetail, Long> {

    List<PurchasesDetail> findAllByPurchasesId(Long id);
}
