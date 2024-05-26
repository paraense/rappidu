package br.com.rappidu.infra.repositories;

import br.com.rappidu.application.dto.responses.ProductType;
import br.com.rappidu.domain.mappers.ProductMapper;
import br.com.rappidu.domain.models.Product;
import br.com.rappidu.domain.repositories.ProductRepositoryPortOut;
import br.com.rappidu.infra.entities.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPortOut {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    @Override
    public void save(Product product) {
        ProductEntity entidade = mapper.toEntity(product);
        repository.save(entidade);
    }

    @Override
    public List<Product> findByType(ProductType productType) {
        var listProductsEntities = repository.findByType(productType);
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
