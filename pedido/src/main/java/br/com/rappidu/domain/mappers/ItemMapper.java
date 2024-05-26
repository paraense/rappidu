package br.com.rappidu.domain.mappers;

import br.com.rappidu.domain.models.Item;
import br.com.rappidu.infra.entities.ItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemEntity toEntity(Item model);
    Item toModel(ItemEntity entity);
}
