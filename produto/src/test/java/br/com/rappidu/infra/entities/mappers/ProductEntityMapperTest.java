package br.com.rappidu.infra.entities.mappers;

import br.com.rappidu.domain.models.Product;
import br.com.rappidu.domain.models.ProductType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest(classes = ProductEntityMapper.class)
class ProductEntityMapperTest {

    @Autowired
    ProductEntityMapper mapper;

    @Test
    void toEntity() {
        Product product = new Product(1L, "Hamburguer", new BigDecimal("10.50"), ProductType.LANCHE);

        var entity = mapper.toEntity(product);

    }

    @Test
    void toModel() {
    }

    @Test
    void merge() {
    }

    @Test
    void typeToEntity() {
    }

    @Test
    void typeToModel() {
    }
}