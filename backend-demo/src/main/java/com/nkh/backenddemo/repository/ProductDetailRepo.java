package com.nkh.backenddemo.repository;

import com.nkh.backenddemo.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepo extends JpaRepository<ProductDetail,Long> {

    Iterable<Long> getAllById(Long id);
}
