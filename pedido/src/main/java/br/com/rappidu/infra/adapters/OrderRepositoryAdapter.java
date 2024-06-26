package br.com.rappidu.infra.adapters;

import br.com.rappidu.domain.exceptions.InvalidProductException;
import br.com.rappidu.domain.exceptions.OrderNotFountException;

import br.com.rappidu.domain.repositories.OrderRepositoryPortOut;

import br.com.rappidu.domain.models.Order;
import br.com.rappidu.domain.models.Product;

import br.com.rappidu.infra.entities.mappers.OrderEntityMapper;
import br.com.rappidu.infra.entities.mappers.ProductEntityMapper;
import br.com.rappidu.infra.repositories.OrderRepository;
import br.com.rappidu.infra.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPortOut {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productMapper;
    private final OrderRepository repo;
    private final OrderEntityMapper mapper;

    @Override
    public Order save(Order order) {
        var entity = mapper.toEntity(order);
        var response = repo.save(entity);
        return mapper.toModel(response);
    }

    @Override
    public Product findProductByCode(Long code) {
        return productRepository.findById(code)
                .map(productMapper::toModel)
                .orElseThrow(() ->  new InvalidProductException("Product code invalid or not exist"));
    }

    @Override
    public Order findByCode(Long id) {
        return repo.findById(id)
                .map(mapper::toModel)
                .orElseThrow(() -> new OrderNotFountException("Order Not Found"));
    }

    @Override
    public List<Order> findAll() {
       return mapper.toModel(repo.findAll());
    }

}
