package com.reactive.shopreactive.domain.service;

import com.reactive.shopreactive.domain.dto.CategoryDto;
import com.reactive.shopreactive.domain.dto.ProductDto;
import com.reactive.shopreactive.domain.repository.ProductRepository;
import io.reactivex.rxjava3.core.Single;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.reactive.shopreactive.common.ApiTag.DEBUG;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public Single<ProductDto> save(ProductDto dto){
        return Single.create(emitter -> {
            Optional<CategoryDto> foundCategory = categoryService.findById(dto.getCategoryId()).toFuture().get();
            if(foundCategory.isEmpty()){
                throw new NotFoundException("No existe categoria");
            }
            dto.setCategory(foundCategory.get());
            log.info(DEBUG + dto);
            emitter.onSuccess(this.repository.save(dto));
        });
    }

    public Single<List<ProductDto>> findAll(){
        return Single.create(emitter -> {
            emitter.onSuccess(repository.findAll());
        });
    }

    public Single<Optional<ProductDto>> findById(long id){
        return Single.create(emitter -> {
            emitter.onSuccess(repository.findById(id));
        });
    }
}
