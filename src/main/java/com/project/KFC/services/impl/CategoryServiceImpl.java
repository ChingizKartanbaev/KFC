package com.project.KFC.services.impl;

import com.project.KFC.models.Category;
import com.project.KFC.repositories.CategoryRep;
import com.project.KFC.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRep rep;

    @Autowired
    public CategoryServiceImpl(CategoryRep rep) {
        this.rep = rep;
    }

    @Override
    public Category save(Category t) {
        return rep.save(t);
    }

    @Override
    public Category findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Category update(Long id, Category category) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return rep.findAll();
    }
}
