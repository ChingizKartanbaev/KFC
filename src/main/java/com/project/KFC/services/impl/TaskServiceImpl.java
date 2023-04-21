package com.project.KFC.services.impl;

import com.project.KFC.models.Task;
import com.project.KFC.repositories.TaskRep;
import com.project.KFC.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRep rep;

    @Autowired
    public TaskServiceImpl(TaskRep rep) {
        this.rep = rep;
    }

    @Override
    public Task save(Task t) {
        return rep.save(t);
    }

    @Override
    public Task findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Task update(Long id, Task task) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return rep.findAll();
    }
}
