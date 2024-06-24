package br.com.rappidu.application.mappers;


import br.com.rappidu.application.dto.request.CustomerRequestDto;
import br.com.rappidu.application.dto.response.CustomerResponseDto;
import br.com.rappidu.domain.models.Customer;
import br.com.rappidu.infra.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressModelMapper.class})
public interface CustomerModelMapper {
    Customer toModel(CustomerRequestDto request);
    CustomerResponseDto toResponseDTO(Customer customer);
}
