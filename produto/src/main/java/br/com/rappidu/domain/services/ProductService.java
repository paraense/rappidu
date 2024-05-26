package br.com.rappidu.domain.services;

import br.com.rappidu.application.dto.responses.ProductType;
import br.com.rappidu.domain.models.Product;

import java.util.List;

public interface ProductService {
    void create(Product produto);

    List<Product> findByType(ProductType productType);

    void remove(Long id);

    void update(Long id, Product product);

    List<Product> all();

}
