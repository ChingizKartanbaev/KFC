package com.project.KFC.services.impl;

import com.project.KFC.models.PurchasesStatus;
import com.project.KFC.repositories.PurchasesStatusRep;
import com.project.KFC.services.PurchasesStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasesStatusServiceImpl implements PurchasesStatusService {

    private final PurchasesStatusRep rep;

    @Autowired
    public PurchasesStatusServiceImpl(PurchasesStatusRep rep) {
        this.rep = rep;
    }

    @Override
    public PurchasesStatus save(PurchasesStatus t) {
        return rep.save(t);
    }

    @Override
    public PurchasesStatus findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PurchasesStatus update(Long id, PurchasesStatus purchasesStatus) {
        return null;
    }

    @Override
    public List<PurchasesStatus> findAll() {
        return rep.findAll();
    }
}
