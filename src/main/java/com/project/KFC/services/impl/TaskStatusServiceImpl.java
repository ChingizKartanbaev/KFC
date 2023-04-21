package com.project.KFC.services.impl;

import com.project.KFC.models.TaskStatus;
import com.project.KFC.repositories.TaskStatusRep;
import com.project.KFC.services.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {

    private final TaskStatusRep rep;

    @Autowired
    public TaskStatusServiceImpl(TaskStatusRep rep) {
        this.rep = rep;
    }

    @Override
    public TaskStatus save(TaskStatus t) {
        return rep.save(t);
    }

    @Override
    public TaskStatus findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TaskStatus update(Long id, TaskStatus taskStatus) {
        return null;
    }

    @Override
    public List<TaskStatus> findAll() {
        return rep.findAll();
    }
}
