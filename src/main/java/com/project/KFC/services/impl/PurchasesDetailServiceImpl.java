package com.project.KFC.services.impl;

import com.project.KFC.models.PurchasesDetail;
import com.project.KFC.repositories.PurchasesDetailRep;
import com.project.KFC.services.PurchasesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasesDetailServiceImpl implements PurchasesDetailService {

    private final PurchasesDetailRep rep;

    @Autowired
    public PurchasesDetailServiceImpl(PurchasesDetailRep rep) {
        this.rep = rep;
    }

    @Override
    public PurchasesDetail save(PurchasesDetail t) {
        return rep.save(t);
    }

    @Override
    public PurchasesDetail findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PurchasesDetail update(Long id, PurchasesDetail purchasesDetail) {
        return null;
    }

    @Override
    public List<PurchasesDetail> findAll() {
        return null;
    }
}
