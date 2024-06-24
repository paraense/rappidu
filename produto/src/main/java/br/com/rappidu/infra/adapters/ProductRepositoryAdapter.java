package br.com.rappidu.infra.adapters;

import br.com.rappidu.domain.models.Product;
import br.com.rappidu.domain.models.ProductType;
import br.com.rappidu.domain.repositories.ProductRepositoryPortOut;
import br.com.rappidu.infra.entities.ProductEntity;
import br.com.rappidu.infra.entities.mappers.ProductEntityMapper;
import br.com.rappidu.infra.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPortOut {

    private final ProductEntityMapper mapper;
    private final ProductRepository repository;

    @Override
    public void save(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        repository.save(entity);
    }

    @Override
    public List<Product> findByType(ProductType productType) {
        var listProductsEntities = repository.findByType(productType.getCode());

        return listProductsEntities.stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, Product product) {
        var entity = repository.findById(id);
        var entityUpdated = mapper.merge(product, entity.get());
        repository.save(entityUpdated);
    }

    @Override
    public List<Product> all() {
        return repository.findAll().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }
}
