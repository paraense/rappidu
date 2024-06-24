package br.com.rappidu.domain.services;

import br.com.rappidu.domain.models.Customer;
import br.com.rappidu.domain.models.Cpf;

public interface CustomerService {
    Customer findByCpf(Cpf cpf);
    Customer create(Customer customer);
}
