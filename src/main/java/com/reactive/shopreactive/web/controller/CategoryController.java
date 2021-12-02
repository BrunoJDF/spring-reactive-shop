package com.reactive.shopreactive.web.controller;

import com.reactive.shopreactive.domain.service.CategoryService;
import com.reactive.shopreactive.web.constants.ApiMapping;
import io.reactivex.rxjava3.core.Single;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMapping.CATEGORY)
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public Single<ResponseEntity> findAll(){
        return service.findAll().map(ResponseEntity::ok);
    }
}
