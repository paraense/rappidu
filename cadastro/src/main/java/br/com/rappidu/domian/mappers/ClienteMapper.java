package br.com.rappidu.domian.mappers;


import br.com.rappidu.application.dto.request.ClienteRequest;
import br.com.rappidu.application.dto.response.ClienteResponse;
import br.com.rappidu.domian.models.Cliente;
import br.com.rappidu.infra.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EndercoMapper.class})
public interface ClienteMapper {

    Cliente toModel(ClienteEntity entity);
    Cliente toModel(ClienteRequest request);
    ClienteResponse toResponseDTO(Cliente cliente);

    ClienteEntity toEntity(Cliente cliente);


}
