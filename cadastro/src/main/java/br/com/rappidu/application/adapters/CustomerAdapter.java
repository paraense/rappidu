package br.com.rappidu.application.adapters;

import br.com.rappidu.application.dto.request.CustomerRequestDto;
import br.com.rappidu.application.dto.response.CustomerResponseDto;
import br.com.rappidu.application.mappers.CustomerModelMapper;
import br.com.rappidu.domain.models.Cpf;
import br.com.rappidu.domain.models.Customer;
import br.com.rappidu.domain.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;



@Component
@ComponentScan(
        basePackages = "br.com.rappidu.domain.services",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = CustomerService.class
        )
)
@AllArgsConstructor
public class CustomerAdapter {

    private final CustomerService service;
    private final CustomerModelMapper mapper;

    public CustomerResponseDto findByCpf(String cpf) {
        Customer customer = service.findByCpf(new Cpf(cpf));
        return mapper.toResponseDTO(customer);
    }

    public CustomerResponseDto create(CustomerRequestDto customerRequestDto) {
        Customer customer = mapper.toModel(customerRequestDto);
        Customer response = service.create(customer);

        return mapper.toResponseDTO(response);
    }
}
