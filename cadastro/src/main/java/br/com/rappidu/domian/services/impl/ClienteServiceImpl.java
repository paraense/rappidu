package br.com.rappidu.domian.services.impl;

import br.com.rappidu.domian.mappers.ClienteMapper;
import br.com.rappidu.domian.models.Cliente;
import br.com.rappidu.domian.models.Cpf;
import br.com.rappidu.domian.services.ClienteService;
import br.com.rappidu.infra.entities.ClienteEntity;
import br.com.rappidu.infra.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    @Override
    public Cliente buscarPorCpf(Cpf cpf) throws ChangeSetPersister.NotFoundException {
         return repository.findByCpf(cpf.get())
                 .map(mapper::toModel)
                 .orElseThrow(ChangeSetPersister.NotFoundException::new); //TODO Criar execção apropriada
    }

    @Override
    public Long criar(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        ClienteEntity response = repository.save(entity);
        return response.getId();
    }
}
