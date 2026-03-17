package com.nkh.backenddemo.service.Implement;

import com.nkh.backenddemo.dto.request.AssignProductOfferingReq;
import com.nkh.backenddemo.entity.ProductDetail;
import com.nkh.backenddemo.entity.ProductOffering;
import com.nkh.backenddemo.entity.ProductOfferingDetail;
import com.nkh.backenddemo.repository.ProductDetailRepo;
import com.nkh.backenddemo.repository.ProductOfferingDetailRepo;
import com.nkh.backenddemo.repository.ProductOfferingRepo;
import com.nkh.backenddemo.service.ProductOfferingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductOfferingDetailServiceImpl implements ProductOfferingDetailService {
    @Autowired
    ProductOfferingDetailRepo productOfferingDetailRepo;

    @Autowired
    ProductOfferingRepo productOfferingRepo;

    @Autowired
    ProductDetailRepo productDetailRepo;

    @Override
    public ProductOffering assign(AssignProductOfferingReq request) {
        //validate
        if (request.getProductOfferingId() == null) {
            throw new RuntimeException("productOfferingId must be not null");
        }
        if (request.getProductDetailId() == null || request.getProductDetailId().isEmpty()) {
            throw new RuntimeException("productDetailId must be not null");
        }
        Optional<ProductOffering> productOfferingOptional = productOfferingRepo.findById(request.getProductOfferingId());
        if (productOfferingOptional.isEmpty()) {
            throw new RuntimeException("productOfferingId not exist");
        }
        List<ProductDetail> productDetails = productDetailRepo.findAllById(request.getProductDetailId());
        if (productDetails.isEmpty()) {
            throw new RuntimeException("productDetailIds not exist");
        }

        //logic
        //1-1.delete all then add
        //productOfferingDetailRepo.deleteByProductOfferingId(request.getProductOfferingId());
        //1-2. override field
        //2. add
        List<ProductOfferingDetail> productOfferingDetailList = new ArrayList<>();

        for (int i = 0; i < productDetails.size(); i++) {
            ProductOfferingDetail productOfferingDetail = new ProductOfferingDetail();
            productOfferingDetail.setProductOffering(productOfferingOptional.get());
            productOfferingDetail.setProductDetail(productDetails.get(i));
            productOfferingDetailList.add(productOfferingDetail);
        }

        productOfferingDetailRepo.saveAll(productOfferingDetailList);
        return productOfferingOptional.get();
    }
}
