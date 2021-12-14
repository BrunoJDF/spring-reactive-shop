package com.reactive.shopreactive.persistence.mapper;

import com.reactive.shopreactive.domain.dto.product.ProductDto;
import com.reactive.shopreactive.persistence.entity.ProductEntity;
import org.mapstruct.*;

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

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "precioVenta", source = "price"),
            @Mapping(target = "nombre", source = "name"),
            @Mapping(target = "idCategoria", source = "categoryId"),
            @Mapping(target = "estado", source = "active"),
            @Mapping(target = "category", source = "category"),
            @Mapping(target = "cantidadStock", source = "stock"),
            @Mapping(target = "idProducto", ignore = true),
            @Mapping(target = "codigoBarras", ignore = true),
    })
    void updateProductFromDto(ProductDto dto, @MappingTarget ProductEntity entity);
}
