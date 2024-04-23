package br.com.rappidu.domian.mappers;

import br.com.rappidu.domian.models.Endereco;
import br.com.rappidu.infra.entities.EnderecoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EndercoMapper {
    EnderecoEntity toEntity(Endereco endereco);
    List<EnderecoEntity> toEntity(List<Endereco> enderecos);
}
