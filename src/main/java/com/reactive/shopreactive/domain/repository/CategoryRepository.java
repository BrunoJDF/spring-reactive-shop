package com.reactive.shopreactive.domain.repository;

import com.reactive.shopreactive.domain.dto.CategoryDto;
import io.reactivex.rxjava3.core.Single;

import java.util.List;

public interface CategoryRepository {
    Single<CategoryDto> save(CategoryDto categoryDto);
    Single<List<CategoryDto>> findAll();
}
