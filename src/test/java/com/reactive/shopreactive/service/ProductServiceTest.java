package com.reactive.shopreactive.service;

import com.reactive.shopreactive.domain.repository.ProductRepository;
import com.reactive.shopreactive.domain.service.ProductService;
import com.reactive.shopreactive.persistence.entity.ProductEntity;
import com.reactive.shopreactive.persistence.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {


    @Test
    public void createProductTest(){


    }

}
