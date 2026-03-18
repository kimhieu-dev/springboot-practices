package com.nkh.backenddemo.controller;

import com.nkh.backenddemo.dto.request.ProductDetailReq;
import com.nkh.backenddemo.entity.ProductDetail;
import com.nkh.backenddemo.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/product-details")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping
    public ResponseEntity<List<ProductDetail>> getAll(){
        List<ProductDetail> response = productDetailService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductDetail> create(ProductDetailReq request){
        ProductDetail response = productDetailService.create(request);
        return ResponseEntity.ok(response);
    }
}
