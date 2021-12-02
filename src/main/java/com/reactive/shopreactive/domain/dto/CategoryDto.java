package com.reactive.shopreactive.domain.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private long id;
    private String description;
    private boolean active;
}
