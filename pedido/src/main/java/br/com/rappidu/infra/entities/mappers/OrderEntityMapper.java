package br.com.rappidu.infra.entities.mappers;

import br.com.rappidu.domain.models.Order;
import br.com.rappidu.infra.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ItemEntityMapper.class)
public interface OrderEntityMapper {


    @Mapping(target = "id", source = "code")
    OrderEntity toEntity(Order order);

    @Mapping(target = "code", source = "id")
    Order toModel(OrderEntity entity);

    @Mapping(target = "code", source = "id")
    List<Order> toModel(List<OrderEntity> entity);

}
