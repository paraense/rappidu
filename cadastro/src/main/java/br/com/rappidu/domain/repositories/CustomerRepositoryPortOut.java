package br.com.rappidu.domain.repositories;

import br.com.rappidu.domain.models.Customer;

public interface CustomerRepositoryPortOut {

    Customer findByCpf(String cpf);

    Customer save(Customer customer);
}
