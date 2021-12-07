package com.reactive.shopreactive.persistence.repository;

import com.reactive.shopreactive.domain.dto.CategoryDto;
import com.reactive.shopreactive.domain.repository.CategoryRepository;
import com.reactive.shopreactive.persistence.crud.CategoryCrudRepository;
import com.reactive.shopreactive.persistence.entity.CategoryEntity;
import com.reactive.shopreactive.persistence.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
    private final CategoryCrudRepository repository;
    private final CategoryMapper mapper;

    public CategoryRepositoryImpl(CategoryCrudRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryEntity> listCategories = (List<CategoryEntity>) repository.findAll();
        return mapper.toListCategoryDto((List<CategoryEntity>) repository.findAll());
    }

    @Override
    public Optional<CategoryDto> findById(long id) {
        return repository.findById(id).map(mapper::toCategoryDto);
    }
}
