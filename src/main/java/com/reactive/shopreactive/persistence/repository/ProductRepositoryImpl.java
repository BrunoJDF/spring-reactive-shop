package com.reactive.shopreactive.persistence.repository;

import com.reactive.shopreactive.common.ApiTag;
import com.reactive.shopreactive.domain.dto.ProductDto;
import com.reactive.shopreactive.domain.repository.ProductRepository;
import com.reactive.shopreactive.persistence.crud.ProductCrudRepository;
import com.reactive.shopreactive.persistence.entity.ProductEntity;
import com.reactive.shopreactive.persistence.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private final ProductCrudRepository repository;
    private final ProductMapper mapper;

    public ProductRepositoryImpl(ProductCrudRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> productList = (List<ProductEntity>) repository.findAll();
        return mapper.toListProductsDto(productList);
    }

    @Override
    public ProductDto save(ProductDto dto) {
        log.info(ApiTag.DEBUG + dto);
        ProductEntity entity = repository.save(mapper.toProductEntity(dto));
        log.info(ApiTag.DEBUG + entity);
        return mapper.toProductDto(entity);
    }

    @Override
    public Optional<ProductDto> findByCategoryId(long id) {
        Optional<ProductEntity> found = repository.findByIdCategoria(id);
        return found.map(mapper::toProductDto);
    }

    @Override
    public Optional<ProductDto> findById(long id) {
        return repository.findById(id).map(mapper::toProductDto);
    }

    @Override
    public Optional<ProductDto> findByName(String name) {
        return repository.findByNombre(name).map(mapper::toProductDto);
    }

    @Override
    public Optional<ProductDto> update(ProductDto foundProduct, ProductDto changes) {
        ProductEntity changed;
        try {
            ProductEntity entity = mapper.toProductEntity(foundProduct);
            mapper.updateProductFromDto(changes, entity);
            changed = repository.save(entity);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
        return Optional.of(changed).map(mapper::toProductDto);
    }
}
