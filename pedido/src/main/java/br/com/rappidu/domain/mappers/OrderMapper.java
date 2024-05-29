package br.com.rappidu.domain.mappers;

import br.com.rappidu.application.dto.request.OrderRequestDto;
import br.com.rappidu.application.dto.response.OrderResponseDto;
import br.com.rappidu.domain.models.Order;
import br.com.rappidu.domain.models.OrderRequest;
import br.com.rappidu.infra.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface OrderMapper {

    OrderRequest toModel(OrderRequestDto orderRequestDto);

    OrderResponseDto toResponseDto(Order order);

    List<OrderResponseDto> toResponseDto(List<Order> order);

    @Mapping(target = "id", source = "code")
    OrderEntity toEntity(Order order);

    @Mapping(target = "code", source = "id")
    Order toModel(OrderEntity entity);

    @Mapping(target = "code", source = "id")
    List<Order> toModel(List<OrderEntity> entity);

}
