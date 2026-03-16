package com.nkh.backenddemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignProductOfferingReq implements Serializable {
    private Long productOfferingId;
    private List<Long> productDetailId;
}
