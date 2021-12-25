package com.reactive.shopreactive.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private long id;
    private long categoryId;
    private String name;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private CategoryDto category;
}
