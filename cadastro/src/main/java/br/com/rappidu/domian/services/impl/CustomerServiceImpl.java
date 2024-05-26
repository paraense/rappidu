package br.com.rappidu.domian.services.impl;

import br.com.rappidu.domian.models.Customer;
import br.com.rappidu.domian.models.Cpf;
import br.com.rappidu.domian.repositories.CustomerRepositoryPortOut;
import br.com.rappidu.domian.services.CustomerService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
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
