package com.nkh.backenddemo.repository;

import com.nkh.backenddemo.entity.ProductOfferingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOfferingDetailRepo extends JpaRepository<ProductOfferingDetail,Long> {
    void deleteByProductOfferingId(Long productOfferingId);
}
