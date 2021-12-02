package com.reactive.shopreactive.persistence.mapper;

import com.reactive.shopreactive.domain.dto.CategoryDto;
import com.reactive.shopreactive.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "id"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "estado", target = "active"),
    })
    CategoryDto toCategoryDto(CategoryEntity category);
    List<CategoryDto> toListCategoryDto(List<CategoryEntity> listCategories);

    @InheritInverseConfiguration
    @Mapping(target = "listaProductos", ignore = true)
    CategoryEntity toCategory(CategoryDto categoryDto);
}
