package com.lucaskaitomurakami.dellitacademy18backend.services;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.ProductDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Product;

public interface ProductService {

    ProductDTO createProduct(String name, double weigth);
}
