package com.reactive.shopreactive.persistence.mapper;

import com.reactive.shopreactive.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CategoryEntity.class)
public interface ProductMapper {
}
