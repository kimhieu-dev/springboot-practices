package com.nkh.backenddemo.service;

import com.nkh.backenddemo.dto.request.AssignProductOfferingReq;
import com.nkh.backenddemo.entity.ProductOffering;

public interface ProductOfferingDetailService {
    ProductOffering assign(AssignProductOfferingReq assignProductOfferingReq);
}
