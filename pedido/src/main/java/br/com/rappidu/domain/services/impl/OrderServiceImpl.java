package br.com.rappidu.domain.services.impl;

import br.com.rappidu.domain.repositories.OrderRepositoryPortOut;
import br.com.rappidu.domain.models.*;
import br.com.rappidu.domain.services.OrderService;
import br.com.rappidu.domain.models.Product;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepositoryPortOut repo;

    @Override
    public Order create(OrderRequest orderRequest) {
        Order order = buildOrder(orderRequest);
        return repo.save(order);
    }

    @Override
    public List<Order> listAll() {
        return repo.findAll();
    }

    @Override
    public Order pay(Long oderId) {
        Order order = repo.findByCode(oderId);
        order.pay();
        return repo.save(order);
    }

    @Override
    public Order findByCode(Long code) {
        return repo.findByCode(code);
    }

    private Order buildOrder(OrderRequest orderRequest) {
        List<Item> items = productRequestListToItems(orderRequest.products());
        return new Order(null,orderRequest.customerName(), items, StatusOrder.WAIT_PAYMENT);
    }

    private List<Item> productRequestListToItems(List<ProductRequest> productsRequest) {
        List<Item> items = new ArrayList<>();

        for (ProductRequest productRequest :  productsRequest) {
            Long code = productRequest.cod();
            Product product = repo.findProductByCode(productRequest.cod());

            Item item = new Item(code, product.name(), product.price(), productRequest.customs());
            items.add(item);
        }
        return items;
    }
}
