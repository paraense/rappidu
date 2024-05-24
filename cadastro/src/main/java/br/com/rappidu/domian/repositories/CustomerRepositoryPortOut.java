package br.com.rappidu.domian.repositories;

import br.com.rappidu.domian.models.Customer;

public interface CustomerRepositoryPortOut {

    Customer findByCpf(String cpf);

    Customer save(Customer customer);
}
