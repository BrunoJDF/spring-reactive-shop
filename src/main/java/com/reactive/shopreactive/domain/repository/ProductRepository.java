package com.reactive.shopreactive.domain.repository;

import com.reactive.shopreactive.domain.dto.ProductDto;
import io.reactivex.rxjava3.core.Single;

import java.util.List;

public interface ProductRepository {
    Single<List<ProductDto>> findAllProducts();
}
