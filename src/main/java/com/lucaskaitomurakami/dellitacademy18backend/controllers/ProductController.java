package com.lucaskaitomurakami.dellitacademy18backend.controllers;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.ProductDTO;
import com.lucaskaitomurakami.dellitacademy18backend.services.implementation.ProductServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {

    ProductServiceImplementation productServiceImplementation;

    // Build Create Product REST API
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProduct = productServiceImplementation.createProduct(productDTO.getName(), productDTO.getWeight());
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
