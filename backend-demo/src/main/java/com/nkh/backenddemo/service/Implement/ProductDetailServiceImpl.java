package com.nkh.backenddemo.service.Implement;

import com.nkh.backenddemo.dto.request.ProductDetailReq;
import com.nkh.backenddemo.entity.ProductDetail;
import com.nkh.backenddemo.repository.ProductDetailRepo;
import com.nkh.backenddemo.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepo productDetailRepo;
    @Override
    public List<ProductDetail> getAll() {
        return productDetailRepo.findAll();
    }

    @Override
    public ProductDetail create(ProductDetailReq productDetailReq) {
        //validate
        if(productDetailReq.getWeight() == null
        || productDetailReq.getBrand() == null
        || productDetailReq.getDescription() == null){
            throw new RuntimeException("field must be not null");
        }
        //assign
        ProductDetail productDetail = new ProductDetail();
        productDetail.setWeight(productDetailReq.getWeight());
        productDetail.setBrand(productDetailReq.getBrand());
        productDetail.setDescription(productDetailReq.getDescription());
        return productDetail;
    }

    @Override
    public ProductDetail getById(Long id) {
        Optional<ProductDetail> productDetailOptional = productDetailRepo.findById(id);
        if(productDetailOptional.isEmpty()){
            throw new RuntimeException("detail not exist");
        }
        return productDetailOptional.get();
    }
}
