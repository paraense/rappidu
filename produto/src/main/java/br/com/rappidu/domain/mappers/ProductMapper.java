package br.com.rappidu.domain.mappers;

import br.com.rappidu.application.dto.request.ProductRequest;
import br.com.rappidu.application.dto.responses.ProductResponse;
import br.com.rappidu.domain.models.Product;
import br.com.rappidu.infra.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy =
        NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductEntity toEntity(Product product);

    Product toModel(ProductRequest product);

    Product toModel(ProductEntity product);

    ProductResponse toResponse(Product product);
    ProductEntity merge(Product model, @MappingTarget ProductEntity entity);

}
