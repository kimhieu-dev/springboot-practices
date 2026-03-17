package com.nkh.backenddemo.service;

import com.nkh.backenddemo.dto.request.ProductOfferingReq;
import com.nkh.backenddemo.entity.ProductOffering;

import java.util.List;

public interface ProductOfferingService {
    ProductOffering getById(Long id);
    List<ProductOffering> getAll();
    List<ProductOffering> getByName(String name);
    List<ProductOffering> getByNameAndPrice(String name, Long price);
    ProductOffering save(ProductOfferingReq productOfferingReq);
    List<ProductOffering> filter(String name, Long minPrice, Long maxPrice, String color, String status);
}
