package com.reactive.shopreactive.domain.repository;

import com.reactive.shopreactive.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDto> findAll();

    ProductDto save(ProductDto dto);

    Optional<ProductDto> findByCategoryId(long id);

    Optional<ProductDto> findById(long id);

    Optional<ProductDto> findByName(String name);

    Optional<ProductDto> update(ProductDto productDto, ProductDto changes);
}
