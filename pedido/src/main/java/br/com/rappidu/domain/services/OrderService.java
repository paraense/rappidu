package br.com.rappidu.domain.services;

import br.com.rappidu.domain.models.Order;
import br.com.rappidu.domain.models.OrderRequest;
import br.com.rappidu.domain.models.StatusOrder;

import java.util.List;

public interface OrderService {
    Order create(OrderRequest orderRequest);
    void updateStatus(Long id, StatusOrder status);
    List<Order> listAll();
    Order pay(Long oderId);
    Order findByCode(Long code);
}
