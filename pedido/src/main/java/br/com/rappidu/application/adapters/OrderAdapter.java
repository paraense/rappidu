package br.com.rappidu.application.adapters;

import br.com.rappidu.application.dto.request.OrderRequestDto;
import br.com.rappidu.application.dto.response.OrderResponseDto;
import br.com.rappidu.domain.mappers.OrderMapper;
import br.com.rappidu.domain.models.Order;
import br.com.rappidu.domain.models.OrderRequest;
import br.com.rappidu.domain.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan(
        basePackages = "br.com.rappidu.domain.services",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = OrderService.class
        )
)
@AllArgsConstructor
public class OrderAdapter {

    private final OrderService service;
    private final OrderMapper mapper;

    public OrderResponseDto create(OrderRequestDto orderRequestDto) {
        OrderRequest request = mapper.toModel(orderRequestDto);
        Order response = service.create(request);

        return mapper.toResponseDto(response);
    }

    public OrderResponseDto pay(Long code) {
        Order order = service.pay(code);
        return mapper.toResponseDto(order);
    }

    public OrderResponseDto findByCode(Long code) {
        Order order = service.findByCode(code);
        return mapper.toResponseDto(order);
    }

    public List<OrderResponseDto> findAll() {
        List<Order> orders = service.listAll();
        return mapper.toResponseDto(orders);
    }
}
