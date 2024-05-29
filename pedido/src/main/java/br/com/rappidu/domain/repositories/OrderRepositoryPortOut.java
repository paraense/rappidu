package br.com.rappidu.domain.repositories;

import br.com.rappidu.domain.models.Order;
import br.com.rappidu.domain.models.Product;

import java.util.List;

public interface OrderRepositoryPortOut {
    Order save(Order order);
    Product findProductByCode(Long id);
    Order findByCode(Long id);
    List<Order> findAll();
}
