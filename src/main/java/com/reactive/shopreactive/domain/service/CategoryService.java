package com.reactive.shopreactive.domain.service;

import com.reactive.shopreactive.domain.dto.CategoryDto;
import com.reactive.shopreactive.domain.repository.CategoryRepository;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Single<List<CategoryDto>> findAll(){
        return Single.create(emitter -> {
            emitter.onSuccess(repository.findAll());
        });
    }

    public Single<Optional<CategoryDto>> findById(long id){
        return Single.create(emitter ->{
            emitter.onSuccess(repository.findById(id));
        });
    }
}
