package com.reactive.shopreactive.domain.service;

import com.reactive.shopreactive.common.exceptions.BadRequestException;
import com.reactive.shopreactive.common.message.Descriptions;
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

    public Single<ProductDto> save(ProductDto dto) {
        return Single.create(emitter -> {
            Optional<CategoryDto> foundCategory = categoryService.findById(dto.getCategoryId()).toFuture().get();
            if (foundCategory.isEmpty()) {
                throw new NotFoundException(Descriptions.notFound("Categoria"));
            }
            dto.setCategory(foundCategory.get());
            log.info(DEBUG + dto);
            emitter.onSuccess(this.repository.save(dto));
        });
    }

    public Single<List<ProductDto>> findAll() {
        return Single.create(emitter -> {
            emitter.onSuccess(repository.findAll());
        });
    }

    public Single<Optional<ProductDto>> findById(long id) {
        return Single.create(emitter -> {
            Optional<ProductDto> found = repository.findById(id);
            if (found.isEmpty()) {
                throw new NotFoundException(Descriptions.notFound("Producto"));
            }
            emitter.onSuccess(found);
        });
    }

    public Single<Optional<ProductDto>> findByName(String name) {
        return Single.create(emitter -> {
            Optional<ProductDto> found = repository.findByName(name);
            if (found.isEmpty()) {
                throw new NotFoundException(Descriptions.notFound("Producto"));
            }
            emitter.onSuccess(found);
        });
    }

    public Single<Optional<ProductDto>> update(long id, ProductDto dto) {
        return Single.create(emitter -> {
            Optional<ProductDto> foundProduct = findById(id).toFuture().get();
            if (foundProduct.isEmpty()) {
                throw new NotFoundException(Descriptions.notFound("Producto"));
            }

            Optional<CategoryDto> foundCategory = categoryService.findById(dto.getCategoryId()).toFuture().get();
            if (foundCategory.isEmpty()) {
                throw new NotFoundException(Descriptions.notFound("Categoria"));
            }

            Optional<ProductDto> changed = repository.update(foundProduct.get(), dto);
            if (changed.isEmpty()) {
                throw new BadRequestException(Descriptions.badRequest("Producto"));
            }
            emitter.onSuccess(changed);
        });
    }
}
