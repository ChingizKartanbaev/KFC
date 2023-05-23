package com.project.KFC.services.impl;

import com.project.KFC.enums.PurchasesStatusEnum;
import com.project.KFC.models.Products;
import com.project.KFC.models.Purchases;
import com.project.KFC.models.Response.Basket;
import com.project.KFC.repositories.ProductsRep;
import com.project.KFC.services.CustomerService;
import com.project.KFC.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRep rep;
    private List<Basket> basket = new ArrayList<>();

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
        Products products = findById(id);
        rep.delete(products);
    }

    @Override
    public Products update(Long id, Products products) {
        return null;
    }

    @Override
    public List<Products> findAll() {
        return rep.findAll();
    }

    @Override
    public List<Basket> addToTheBasket(Long id) {
        for (Basket value : basket) {
            if (value.getProducts().getId().equals(id)) {
                value.setAmount(value.getAmount() + 1);
                value.setCost(value.getCost() + findById(id).getPrice());
                value.setProductId(id);
                return basket;
            }
        }

        Basket basketAdd = new Basket();
        Products products = findById(id);
        basketAdd.setProducts(products);
        basketAdd.setAmount(1);
        basketAdd.setCost(products.getPrice());
        basket.add(basketAdd);
        return basket;
    }

    @Override
    public List<Basket> getBasket() {
        return basket;
    }

    @Override
    public double getTotalCost() {
        double totalCost;
        double value = 0;
        for (Basket item: basket) {
            value += item.getCost();
        }
        totalCost = value;
        value = 0;
        return totalCost;
    }

    @Override
    public void deleteFromCart(Long id) {
        for (Basket item : basket) {
            if (item.getAmount() > 1) {
                item.setAmount(item.getAmount() - 1);
                item.setCost(item.getCost() - findById(item.getProductId()).getPrice());
                break;
            }else {
                if(item.getProducts().getId().equals(id)){
                    basket.remove(item);
                    break;
                }
            }
        }
    }



}
