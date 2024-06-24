package br.com.rappidu.domain.services.impl;

import br.com.rappidu.domain.models.Product;
import br.com.rappidu.domain.models.ProductType;
import br.com.rappidu.domain.repositories.ProductRepositoryPortOut;
import br.com.rappidu.domain.services.ProductService;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepositoryPortOut repository;

    @Override
    public void create(Product product) {
        repository.save(product);
    }

    @Override
    public List<Product> findByType(ProductType productTypeResponse) {
        return repository.findByType(productTypeResponse);
    }

    @Override
    public void remove(Long id) {
        repository.remove(id);
    }

    @Override
    public void update(Long id,Product product) {
        repository.update(id,product);
    }

    @Override
    public List<Product> all() {
        return repository.all();
    }


}
