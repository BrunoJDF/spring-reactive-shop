package com.reactive.shopreactive.persistence.repository;

import com.reactive.shopreactive.domain.dto.CategoryDto;
import com.reactive.shopreactive.domain.repository.CategoryRepository;
import com.reactive.shopreactive.persistence.crud.CategoryCrudRepository;
import com.reactive.shopreactive.persistence.entity.CategoryEntity;
import com.reactive.shopreactive.persistence.mapper.CategoryMapper;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
    private final CategoryCrudRepository repository;
    private final CategoryMapper mapper;

    public CategoryRepositoryImpl(CategoryCrudRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Single<CategoryDto> save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public Single<List<CategoryDto>> findAll() {
        return Single.create(subscribe-> {
            List<CategoryEntity> listCategories = (List<CategoryEntity>) repository.findAll();
            if(listCategories.size() > 0){
                subscribe.onSuccess(mapper.toListCategoryDto((List<CategoryEntity>) repository.findAll()));
            }
        });
    }
}
