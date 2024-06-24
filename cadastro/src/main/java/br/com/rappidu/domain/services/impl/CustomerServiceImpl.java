package br.com.rappidu.domain.services.impl;

import br.com.rappidu.domain.models.Customer;
import br.com.rappidu.domain.models.Cpf;
import br.com.rappidu.domain.repositories.CustomerRepositoryPortOut;
import br.com.rappidu.domain.services.CustomerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryPortOut repository;

    @Override
    public Customer findByCpf(Cpf cpf)  {
         return repository.findByCpf(cpf.get());
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }
}
