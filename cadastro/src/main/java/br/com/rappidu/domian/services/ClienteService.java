package br.com.rappidu.domian.services;

import br.com.rappidu.domian.models.Cliente;
import br.com.rappidu.domian.models.Cpf;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface ClienteService {
    Cliente buscarPorCpf(Cpf cpf) throws ChangeSetPersister.NotFoundException;

    Long criar(Cliente cliente);
}
