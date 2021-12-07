package com.reactive.shopreactive.persistence.crud;

import com.reactive.shopreactive.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByIdCategoria(long cageoriaId);

}
