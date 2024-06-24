package br.com.rappidu.application.dto.mappers;

import br.com.rappidu.application.dto.request.OrderRequestDto;
import br.com.rappidu.application.dto.response.OrderResponseDto;
import br.com.rappidu.domain.models.Order;
import br.com.rappidu.domain.models.OrderRequest;
import br.com.rappidu.infra.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderRequest toModel(OrderRequestDto orderRequestDto);

    OrderResponseDto toResponseDto(Order order);

    List<OrderResponseDto> toResponseDto(List<Order> order);
}
