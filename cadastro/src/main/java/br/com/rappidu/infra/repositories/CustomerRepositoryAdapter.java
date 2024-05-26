package br.com.rappidu.infra.repositories;

import br.com.rappidu.domian.exceptions.CustomerNotFoundException;
import br.com.rappidu.domian.mappers.CustomerMapper;
import br.com.rappidu.domian.models.Customer;
import br.com.rappidu.domian.repositories.CustomerRepositoryPortOut;
import br.com.rappidu.infra.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepositoryPortOut {

    private final CustromerRepository repo;
    private final CustomerMapper mapper;

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
