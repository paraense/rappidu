package br.com.rappidu.domian.mappers;

import br.com.rappidu.application.dto.request.AddressRequestDto;
import br.com.rappidu.domian.models.Address;
import br.com.rappidu.infra.entities.AddressEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressEntity toEntity(Address address);
    List<AddressEntity> toEntity(List<Address> addresses);
    Address toModel(AddressRequestDto request);
    List<Address> toModel(List<AddressRequestDto> request);
}
