package com.nkh.backenddemo.repository;

import com.nkh.backenddemo.entity.ProductOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOfferingRepo extends JpaRepository<ProductOffering,Long> {
    List<ProductOffering> findByName (String name);

    List<ProductOffering> findByNameAndPrice(String name, Long price);
}
