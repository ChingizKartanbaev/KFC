package com.project.KFC.repositories;

import com.project.KFC.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRep extends JpaRepository<Position, Long> {
}
