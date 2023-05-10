package com.project.KFC.repositories;

import com.project.KFC.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRep extends JpaRepository<Store, Long>{

    List<Store> getAllByActiveEquals(boolean status);
}
