package com.project.KFC.repositories;

import com.project.KFC.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRep extends JpaRepository<Task, Long> {

    @Query(value = "\n" +
            "select *\n" +
            "from tb_task\n" +
            "where task_status = 'FINISHED'", nativeQuery = true)
    List<Task> findAllNotFinishedTask();
}
