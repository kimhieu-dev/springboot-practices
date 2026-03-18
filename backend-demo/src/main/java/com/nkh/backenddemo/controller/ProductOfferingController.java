package com.nkh.backenddemo.controller;

import com.nkh.backenddemo.dto.request.ProductOfferingReq;
import com.nkh.backenddemo.entity.ProductOffering;
import com.nkh.backenddemo.service.ProductOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/v1/product-offerings")
public class ProductOfferingController {

    @Autowired
    private ProductOfferingService productOfferingService;
    @GetMapping("/{id}")
    public ResponseEntity<ProductOffering> getById(@PathVariable Long id){
       ProductOffering productOffering = productOfferingService.getById(id);
       return ResponseEntity.ok(productOffering);
    }
    @GetMapping
    public ResponseEntity<List<ProductOffering>> getAll(){
        List<ProductOffering> response = productOfferingService.getAll();
        return ResponseEntity.ok(response);
    }
    //filter product offering
    @GetMapping("/filter")
    private ResponseEntity<List<ProductOffering>> filter(
            @RequestParam (name = "name", required = false) String name,
            @RequestParam (name = "minPrice", required = false) Long minPrice,
            @RequestParam (name = "maxPrice", required = false) Long maxPrice,
            @RequestParam (name = "color", required = false) String color,
            @RequestParam (name = "status", required = false) String status
    ){

        List<ProductOffering> response = productOfferingService.filter(name,minPrice,maxPrice,color,status);
        return ResponseEntity.ok(response);
    }
//    @GetMapping("")
//    public ResponseEntity<List<ProductOffering>> getByName(@PathVariable String name){
//        List<ProductOffering> response = productOfferingService.getByName(name);
//        return ResponseEntity.ok(response);
//    }
//    @GetMapping("")
//    public ResponseEntity<List<ProductOffering>> getByNameAndPrice(@PathVariable String name, @PathVariable Long price){
//        List<ProductOffering> response = productOfferingService.getByNameAndPrice(name,price);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping
    public ResponseEntity<ProductOffering> createProduct(@RequestBody ProductOfferingReq request){
        ProductOffering response = productOfferingService.save(request);
        return ResponseEntity.ok(response);
    }

}