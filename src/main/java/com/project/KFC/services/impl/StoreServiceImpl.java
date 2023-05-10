package com.project.KFC.services.impl;

import com.project.KFC.models.Store;
import com.project.KFC.repositories.StoreRep;
import com.project.KFC.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRep rep;
    private Store store;

    @Autowired
    public StoreServiceImpl(StoreRep rep) {
        this.rep = rep;
    }

    @Override
    public Store save(Store t) {
        return rep.save(t);
    }

    @Override
    public Store findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        Store store1 = findById(id);
        store1.setActive(false);
        save(store1);
    }

    @Override
    public Store update(Long id, Store store) {
        return null;
    }

    @Override
    public List<Store> findAll() {
        return rep.getAllByActiveEquals(true);
    }

    @Override
    public Store getStore() {
        return store;
    }

    @Override
    public void setStore(Store store) {
        this.store = store;
    }
}
