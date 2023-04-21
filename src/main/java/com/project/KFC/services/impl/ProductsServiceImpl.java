package com.project.KFC.services.impl;

import com.project.KFC.models.Products;
import com.project.KFC.repositories.ProductsRep;
import com.project.KFC.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRep rep;

    @Autowired
    public ProductsServiceImpl(ProductsRep rep) {
        this.rep = rep;
    }

    @Override
    public Products save(Products t) {
        return rep.save(t);
    }

    @Override
    public Products findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Products update(Long id, Products products) {
        return null;
    }

    @Override
    public List<Products> findAll() {
        return rep.findAll();
    }
}
