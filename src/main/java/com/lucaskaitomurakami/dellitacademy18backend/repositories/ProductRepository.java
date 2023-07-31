package com.lucaskaitomurakami.dellitacademy18backend.repositories;

import com.lucaskaitomurakami.dellitacademy18backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    default Product createProduct(String name, double weigth) {
        Product product = new Product();
        product.setName(name);
        product.setWeight(weigth);
        return product;
    }

    default Double totalWeigth(Product product) {
        return product.getWeight() * product.getQuantity();
    }

}
