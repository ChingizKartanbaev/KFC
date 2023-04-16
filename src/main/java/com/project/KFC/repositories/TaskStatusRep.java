package com.project.KFC.repositories;

import com.project.KFC.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRep extends JpaRepository<TaskStatus, Long> {
}
