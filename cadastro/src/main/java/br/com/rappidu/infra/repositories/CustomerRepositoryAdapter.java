package br.com.rappidu.infra.repositories;

import br.com.rappidu.domain.exceptions.CustomerNotFoundException;

import br.com.rappidu.domain.models.Customer;
import br.com.rappidu.domain.repositories.CustomerRepositoryPortOut;
import br.com.rappidu.infra.entities.CustomerEntity;
import br.com.rappidu.infra.mappers.CustomerEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepositoryPortOut {

    private final CustromerRepository repo;
    private final CustomerEntityMapper mapper;

    @Override
    public Customer findByCpf(String cpf) {
        return repo.findByCpf(cpf)
                .map(mapper::toModel)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = mapper.toEntity(customer);
        CustomerEntity response = repo.save(entity);

        return mapper.toModel(response);
    }
}
