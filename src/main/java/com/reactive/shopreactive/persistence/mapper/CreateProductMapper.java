package com.reactive.shopreactive.persistence.mapper;

import com.reactive.shopreactive.domain.dto.ProductDto;
import com.reactive.shopreactive.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface CreateProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
    })
    ProductDto toCreateProductDto(ProductEntity entity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "")
    })
    ProductEntity toCreateProductEntity(ProductDto dto);
}
