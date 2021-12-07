package com.reactive.shopreactive.repository;

import com.reactive.shopreactive.persistence.crud.ProductCrudRepository;
import com.reactive.shopreactive.persistence.entity.ProductEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductCrudRepository repository;

    @Test
    public void findAll(){
        List<ProductEntity> listProducts = (List<ProductEntity>) repository.findAll();

        Assertions.assertThat(listProducts.size()>5);
    }


}
