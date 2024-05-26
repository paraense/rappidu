package br.com.rappidu.domian.mappers;


import br.com.rappidu.application.dto.request.CustomerRequestDto;
import br.com.rappidu.application.dto.response.CustomerResponseDto;
import br.com.rappidu.domian.models.Customer;
import br.com.rappidu.infra.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface CustomerMapper {

    Customer toModel(CustomerEntity entity);
    Customer toModel(CustomerRequestDto request);
    CustomerResponseDto toResponseDTO(Customer customer);

    CustomerEntity toEntity(Customer customer);
}
