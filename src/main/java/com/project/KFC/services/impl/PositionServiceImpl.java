package com.project.KFC.services.impl;

import com.project.KFC.models.Position;
import com.project.KFC.repositories.PositionRep;
import com.project.KFC.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRep rep;

    @Autowired
    public PositionServiceImpl(PositionRep rep) {
        this.rep = rep;
    }

    @Override
    public Position save(Position t) {
        return rep.save(t);
    }

    @Override
    public Position findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Position update(Long id, Position position) {
        return null;
    }

    @Override
    public List<Position> findAll() {
        return rep.findAll();
    }
}
