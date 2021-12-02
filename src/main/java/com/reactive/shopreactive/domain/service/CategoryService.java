package com.reactive.shopreactive.domain.service;

import com.reactive.shopreactive.domain.dto.CategoryDto;
import com.reactive.shopreactive.domain.repository.CategoryRepository;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Single<List<CategoryDto>> findAll(){
        return repository.findAll();
    }
}
