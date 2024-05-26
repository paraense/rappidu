package br.com.rappidu.application.adapters;


import br.com.rappidu.application.dto.request.CustomerRequestDto;
import br.com.rappidu.application.dto.response.CustomerResponseDto;
import br.com.rappidu.domian.mappers.CustomerMapper;
import br.com.rappidu.domian.models.Cpf;
import br.com.rappidu.domian.models.Customer;
import br.com.rappidu.domian.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    private final CustomerMapper mapper;

    public CustomerResponseDto findByCpf(String cpf) {
        try {
            Customer customer = service.findByCpf(new Cpf(cpf));
            return mapper.toResponseDTO(customer);
        }catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CustomerResponseDto create(CustomerRequestDto customerRequestDto) {
        Customer customer = mapper.toModel(customerRequestDto);
        Customer response = service.create(customer);

        return mapper.toResponseDTO(response);
    }
}
