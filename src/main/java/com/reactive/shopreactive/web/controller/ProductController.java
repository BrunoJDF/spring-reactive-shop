package com.reactive.shopreactive.web.controller;

import com.reactive.shopreactive.domain.dto.ProductDto;
import com.reactive.shopreactive.domain.service.ProductService;
import com.reactive.shopreactive.web.constants.ApiMapping;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(ApiMapping.PRODUCT)
public class ProductController {
    private final ProductService service;

    @GetMapping
    public Single<ResponseEntity<?>> findAll(){
        return service.findAll().map(ResponseEntity::ok);
    }

    @PostMapping
    public Single<ResponseEntity<ProductDto>> save(@RequestBody ProductDto dto){
        return service.save(dto).map(productDto -> {
            return ResponseEntity.ok().body(productDto);
        });
    }

    @GetMapping("{id}")
    public Single<ResponseEntity<?>> findById(@PathVariable long id){
        return service.findById(id).map(ResponseEntity::ok);
    }
}
