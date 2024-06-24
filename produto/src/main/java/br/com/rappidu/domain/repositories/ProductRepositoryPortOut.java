package br.com.rappidu.domain.repositories;

import br.com.rappidu.domain.models.Product;
import br.com.rappidu.domain.models.ProductType;

import java.util.List;

public interface ProductRepositoryPortOut {

    void save(Product product);

    List<Product> findByType(ProductType productTypeResponse);

    void remove (Long id);

    void update (Long id, Product product);

    List<Product> all();
}
