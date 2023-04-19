package com.project.KFC.services;

import java.util.List;

public interface BaseService<Z> {

    Z save(Z t);

    Z findById(Long id);

    void delete(Long id);

    Z update(Long id, Z z);

    List<Z> findAll();

}
