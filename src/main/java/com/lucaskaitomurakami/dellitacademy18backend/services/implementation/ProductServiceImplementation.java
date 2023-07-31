package com.lucaskaitomurakami.dellitacademy18backend.services.implementation;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.ProductDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Product;
import com.lucaskaitomurakami.dellitacademy18backend.mapper.ProductMapper;
import com.lucaskaitomurakami.dellitacademy18backend.repositories.ProductRepository;
import com.lucaskaitomurakami.dellitacademy18backend.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(String name, double weigth) {
        Product product = productRepository.createProduct(name, weigth);
        return ProductMapper.mapToProductDTO(product);
    }

}
