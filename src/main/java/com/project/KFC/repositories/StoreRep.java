package com.project.KFC.repositories;

import com.project.KFC.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRep extends JpaRepository<Store, Long>{
}
