package com.project.KFC.services.impl;

import com.project.KFC.models.Purchases;
import com.project.KFC.repositories.PurchasesRep;
import com.project.KFC.services.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasesServiceImpl implements PurchasesService {

    private final PurchasesRep rep;

    @Autowired
    public PurchasesServiceImpl(PurchasesRep rep) {
        this.rep = rep;
    }

    @Override
    public Purchases save(Purchases t) {
        return rep.save(t);
    }

    @Override
    public Purchases findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Purchases update(Long id, Purchases purchases) {
        return null;
    }

    @Override
    public List<Purchases> findAll() {
        return rep.findAll();
    }
}
