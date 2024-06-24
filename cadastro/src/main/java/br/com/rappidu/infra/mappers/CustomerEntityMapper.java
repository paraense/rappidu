package br.com.rappidu.infra.mappers;


import br.com.rappidu.application.dto.request.CustomerRequestDto;
import br.com.rappidu.application.dto.response.CustomerResponseDto;
import br.com.rappidu.domain.models.Customer;
import br.com.rappidu.infra.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressEntityMapper.class})
public interface CustomerEntityMapper {
    Customer toModel(CustomerEntity entity);
    CustomerEntity toEntity(Customer customer);
}
