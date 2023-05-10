package com.project.KFC.services;

import com.project.KFC.models.Store;

public interface StoreService extends BaseService<Store> {
    Store getStore();
    void setStore(Store store);
}
