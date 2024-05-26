package br.com.rappidu.domian.services;

import br.com.rappidu.domian.models.Customer;
import br.com.rappidu.domian.models.Cpf;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface CustomerService {
    Customer findByCpf(Cpf cpf) throws ChangeSetPersister.NotFoundException;

    Long create(Customer customer);
}
