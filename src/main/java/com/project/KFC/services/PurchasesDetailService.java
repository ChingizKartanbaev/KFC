package com.project.KFC.services;

import com.project.KFC.models.PurchasesDetail;

import java.util.List;

public interface PurchasesDetailService extends BaseService<PurchasesDetail> {

    List<PurchasesDetail> findAllByPurchasesId(Long id);
}
