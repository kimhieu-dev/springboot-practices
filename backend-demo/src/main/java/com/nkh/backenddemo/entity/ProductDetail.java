package com.nkh.backenddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_detail")
public class ProductDetail implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "weight",nullable = false)
    private Long weight;

    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name="description",nullable = false)
    private String description;

    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    List<ProductOfferingDetail> productOfferingDetailList;
}
