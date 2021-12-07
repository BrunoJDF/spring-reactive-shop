package com.reactive.shopreactive.domain.repository;

import com.reactive.shopreactive.domain.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    CategoryDto save(CategoryDto categoryDto);
    List<CategoryDto> findAll();
    Optional<CategoryDto> findById(long id);
}
