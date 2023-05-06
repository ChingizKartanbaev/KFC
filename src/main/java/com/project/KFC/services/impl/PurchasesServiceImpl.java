package com.project.KFC.services.impl;

import com.project.KFC.enums.PurchasesStatusEnum;
import com.project.KFC.models.Purchases;
import com.project.KFC.models.PurchasesDetail;
import com.project.KFC.models.Response.Basket;
import com.project.KFC.repositories.PurchasesRep;
import com.project.KFC.services.CustomerService;
import com.project.KFC.services.ProductsService;
import com.project.KFC.services.PurchasesDetailService;
import com.project.KFC.services.PurchasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchasesServiceImpl implements PurchasesService {

    private final PurchasesRep rep;
    private final ProductsService productsService;
    private final CustomerService customerService;
    private final PurchasesDetailService purchasesDetailService;

    @Autowired
    public PurchasesServiceImpl(PurchasesRep rep, ProductsService productsService, CustomerService customerService, PurchasesDetailService purchasesDetailService) {
        this.rep = rep;
        this.productsService = productsService;
        this.customerService = customerService;
        this.purchasesDetailService = purchasesDetailService;
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

    @Override
    public Long buy() {
        if(customerService.findById(customerService.getCustomer().getId()).getPurchases() != null) {
            if(findById(customerService.findById(customerService.getCustomer().getId()).getPurchases().getId()).getPurchasesStatus() == PurchasesStatusEnum.PROCESS) {
                return 0L;
            }
        }
        Purchases purchases = new Purchases();
        purchases.setPurchasesDate(LocalDateTime.now());
        purchases.setPrice(productsService.getTotalCost());
        purchases.setPurchasesStatus(PurchasesStatusEnum.PROCESS);
        save(purchases);
        customerService.getCustomer().setPurchases(purchases);
        customerService.save(customerService.getCustomer());

        for (Basket item : productsService.getBasket()) {
            PurchasesDetail purchasesDetail = new PurchasesDetail();
            purchasesDetail.setAmount(item.getAmount());
            purchasesDetail.setPurchases(purchases);
            purchasesDetail.setProducts(item.getProducts());
            purchasesDetailService.save(purchasesDetail);
        }
        productsService.getBasket().clear();
        return purchases.getId();
    }

    @Override
    public String checkPurchases() {
        if(customerService.findById(customerService.getCustomer().getId()).getPurchases() == null){
            return "You have not any purchase";
        }
        if(findById(customerService.findById(customerService.getCustomer().getId()).getPurchases().getId()).getPurchasesStatus() == PurchasesStatusEnum.PROCESS) {
            return "not finished";
        } else {
            return "finished. You can pick it up";
        }
    }
}
