package com.reactive.shopreactive.persistence.crud;

import com.reactive.shopreactive.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCrudRepository extends JpaRepository<ProductEntity, Long> {

}
