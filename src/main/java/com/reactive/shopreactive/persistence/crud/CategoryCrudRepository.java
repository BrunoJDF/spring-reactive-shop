package com.reactive.shopreactive.persistence.crud;

import com.reactive.shopreactive.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryEntity, Long> {
}

