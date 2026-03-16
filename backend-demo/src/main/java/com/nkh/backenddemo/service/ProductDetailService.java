package com.nkh.backenddemo.service;

import com.nkh.backenddemo.dto.request.ProductDetailReq;
import com.nkh.backenddemo.entity.ProductDetail;
import com.nkh.backenddemo.entity.ProductOffering;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAll();
    ProductDetail create(ProductDetailReq productDetailReq);
    ProductDetail getById(Long id);
}
