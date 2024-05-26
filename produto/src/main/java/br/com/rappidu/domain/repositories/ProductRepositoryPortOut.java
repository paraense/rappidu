package br.com.rappidu.domain.repositories;

import br.com.rappidu.application.dto.responses.ProductType;
import br.com.rappidu.domain.models.Product;

import java.util.List;

public interface ProductRepositoryPortOut {

    void save(Product product);

    List<Product> findByType(ProductType productType);

    void remove (Long id);

    void update (Long id, Product product);

    List<Product> all();
}
