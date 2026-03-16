package com.nkh.backenddemo.entity;

import com.nkh.backenddemo.common.ProductOfferingCommon;
import com.nkh.backenddemo.repository.ProductOfferingRepo;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_offering")
public class ProductOffering implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 255)
    private String name;

    @Column(name = "price",nullable = false)
    private Long price;

    @Column(name = "color",nullable = true,length = 255)
    private String color;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductOfferingCommon status;

    @OneToMany(mappedBy = "productOffering",cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<ProductOfferingDetail> productOfferingDetailList;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "detail_id")
//    private ProductDetail productDetail;
}
