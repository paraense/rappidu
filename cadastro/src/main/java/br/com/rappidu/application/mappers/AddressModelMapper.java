package br.com.rappidu.application.mappers;

import br.com.rappidu.application.dto.request.AddressRequestDto;
import br.com.rappidu.domain.models.Address;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressModelMapper {
    Address toModel(AddressRequestDto request);
    List<Address> toModel(List<AddressRequestDto> request);
}
