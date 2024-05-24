package br.com.rappidu.domain.mappers;

import br.com.rappidu.application.dto.request.ProdutoRequest;
import br.com.rappidu.application.dto.responses.ProdutoResponse;
import br.com.rappidu.domain.models.Produto;
import br.com.rappidu.infra.entities.ProdutoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoEntity toEntity(Produto produto);

    Produto toModel(ProdutoRequest produto);

    Produto toModel(ProdutoEntity produto);

    ProdutoResponse toResponse(Produto produto);
}
