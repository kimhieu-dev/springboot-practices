package com.nkh.backenddemo.service.Implement;

import com.nkh.backenddemo.common.ProductOfferingCommon;
import com.nkh.backenddemo.dto.request.ProductOfferingReq;
import com.nkh.backenddemo.entity.ProductOffering;
import com.nkh.backenddemo.repository.ProductOfferingRepo;
import com.nkh.backenddemo.service.ProductOfferingService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOfferingServiceImpl implements ProductOfferingService {
    @Autowired
    EntityManager entityManager;
    @Autowired
    private ProductOfferingRepo productOfferingRepo;
    @Override
    public ProductOffering getById(Long id) {
        Optional<ProductOffering> productOfferingOptional = productOfferingRepo.findById(id);
        if(productOfferingOptional.isEmpty()){
            throw new RuntimeException("Ko co product co id nay");
        }else {
            return productOfferingOptional.get();
        }
    }

    @Override
    public List<ProductOffering> getAll() {
        return productOfferingRepo.findAll();
    }

    @Override
    public List<ProductOffering> getByName(String name) {
        return productOfferingRepo.findByName(name);
    }

    @Override
    public List<ProductOffering> getByNameAndPrice(String name, Long price) {
        return productOfferingRepo.findByNameAndPrice(name,price);
    }

    @Override
    public ProductOffering save(ProductOfferingReq productOfferingReq) {
        //validate
        if(productOfferingReq.getName() == null
            || productOfferingReq.getPrice() == null
                || productOfferingReq.getColor() == null
        ){
            throw new RuntimeException("field must be not null");
        }
        //assign
        ProductOffering productOffering = new ProductOffering();
        productOffering.setName(productOfferingReq.getName());
        productOffering.setPrice(productOfferingReq.getPrice());
        productOffering.setColor(productOfferingReq.getColor());
        productOffering.setStatus(ProductOfferingCommon.valueOf("INACTIVE"));

        return productOfferingRepo.save(productOffering);

    }

    @Override
    public List<ProductOffering> filter(String name, Long minPrice, Long maxPrice, String color, String status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
    }
}
