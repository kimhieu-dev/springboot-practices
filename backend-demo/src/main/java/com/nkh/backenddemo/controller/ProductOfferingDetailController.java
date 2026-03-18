package com.nkh.backenddemo.controller;

import com.nkh.backenddemo.dto.request.AssignProductOfferingReq;
import com.nkh.backenddemo.entity.ProductOffering;
import com.nkh.backenddemo.entity.ProductOfferingDetail;
import com.nkh.backenddemo.service.ProductOfferingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/product-offering-detail")
public class ProductOfferingDetailController {
    @Autowired
    private ProductOfferingDetailService productOfferingDetailService;

    @PostMapping
    public ResponseEntity<ProductOffering> create(AssignProductOfferingReq request){
        ProductOffering response = productOfferingDetailService.assign(request);
        return ResponseEntity.ok(response);
    }
}
