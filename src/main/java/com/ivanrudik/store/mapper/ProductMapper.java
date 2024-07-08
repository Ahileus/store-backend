package com.ivanrudik.store.mapper;

import com.ivanrudik.store.dto.ProductDTO;
import com.ivanrudik.store.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static List<ProductDTO> mapToListProductDTO(List<Product> products) {

        return products
                .stream()
                .map(ProductMapper::mapToProductDTO)
                .toList();
                //.collect(Collectors.toList());
    }

    public static Page<ProductDTO> mapToPageProductDTO(Page<Product> products) {

        return products
                .map(ProductMapper::mapToProductDTO);
    }

    public static List<Product> mapToListProduct(List<ProductDTO> productsDTO) {

        return productsDTO
                .stream()
                .map(ProductMapper::mapToProduct)
                .toList();
                //.collect(Collectors.toList());
    }

    public static ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        return productDTO;
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return product;
    }
}
