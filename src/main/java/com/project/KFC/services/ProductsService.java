package com.project.KFC.services;

import com.project.KFC.models.Products;
import com.project.KFC.models.Response.Basket;

import java.util.List;


public interface ProductsService extends BaseService<Products>{
    List<Basket> addToTheBasket(Long id);
    List<Basket> getBasket();
    double getTotalCost();
    void deleteFromCart(Long id);
}
