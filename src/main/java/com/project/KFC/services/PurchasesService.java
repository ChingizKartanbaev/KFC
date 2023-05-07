package com.project.KFC.services;

import com.project.KFC.enums.PurchasesStatusEnum;
import com.project.KFC.models.Purchases;

import java.util.List;


public interface PurchasesService extends BaseService<Purchases> {

    Long buy();

    String checkPurchases();

    List<Purchases> findAllByPurchasesStatus();
}
