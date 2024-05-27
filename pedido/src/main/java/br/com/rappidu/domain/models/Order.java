package br.com.rappidu.domain.models;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class Order {

    private final Long code;
    private final String customerName;
    private final BigDecimal amount;
    private final List<Item> items;
    private StatusOrder status;

    public Order(Long code, String customerName, List<Item> items, StatusOrder status) {
        this.code = code;
        this.status = status;
        this.customerName = customerName;
        this.items = items;
        this.amount = items.stream()
                .map(Item::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void pay() {
        this.status = StatusOrder.OPEN;
    }
}
