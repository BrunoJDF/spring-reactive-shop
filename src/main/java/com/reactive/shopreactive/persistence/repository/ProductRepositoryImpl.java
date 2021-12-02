package com.reactive.shopreactive.persistence.repository;

import com.reactive.shopreactive.domain.dto.ProductDto;
import com.reactive.shopreactive.domain.repository.ProductRepository;
import com.reactive.shopreactive.persistence.crud.ProductCrudRepository;
import io.reactivex.rxjava3.core.Single;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    private final ProductCrudRepository repository;

    public ProductRepositoryImpl(ProductCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<List<ProductDto>> findAllProducts() {
        return Single.create(emitter -> {
            emitter.onSuccess(null);
        });
    }
}
