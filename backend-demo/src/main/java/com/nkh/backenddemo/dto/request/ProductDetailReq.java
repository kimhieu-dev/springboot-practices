package com.nkh.backenddemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailReq implements Serializable {
    private Long weight;

    private String brand;

    private String description;
}
