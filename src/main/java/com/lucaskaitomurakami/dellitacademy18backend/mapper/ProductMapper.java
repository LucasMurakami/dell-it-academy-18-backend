package com.lucaskaitomurakami.dellitacademy18backend.mapper;

import com.lucaskaitomurakami.dellitacademy18backend.DTO.ProductDTO;
import com.lucaskaitomurakami.dellitacademy18backend.entities.Product;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class ProductMapper {

    public static ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }

    public static List<Product> mapToListProduct(List<ProductDTO> productDTOList) {
        return productDTOList.stream().map( (productDTO) -> mapToProduct(productDTO)).toList();
    }

    public static List<ProductDTO> mapToListProductDTO(List<Product> products) {
        return products.stream().map( (product) -> mapToProductDTO(product)).toList();
    }
}
