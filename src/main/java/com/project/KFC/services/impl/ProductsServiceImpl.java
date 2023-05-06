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
        double totalCost = 0;
        for (Basket item: basket) {
            totalCost+= item.getCost();
        }
        return totalCost;
    }

    @Override
    public void deleteFromCart(Long id) {
        for (Basket item : basket) {
            if (item.getAmount() > 1) {
                item.setAmount(item.getAmount() - 1);
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
