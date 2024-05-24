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
         //TODO Criar execção apropriada
    }

    @Override
    public Long criar(Customer customer) {
        var response = repository.save(customer);
        return response.getId();
    }
}
