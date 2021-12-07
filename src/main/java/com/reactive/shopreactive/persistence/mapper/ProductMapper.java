package com.reactive.shopreactive.persistence.mapper;

import com.reactive.shopreactive.domain.dto.ProductDto;
import com.reactive.shopreactive.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "category", target = "category")
    })
    ProductDto toProductDto (ProductEntity entity);
    List<ProductDto> toListProductsDto(List<ProductEntity> entities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "codigoBarras", ignore = true)
    })
    ProductEntity toProductEntity(ProductDto dto);
}
