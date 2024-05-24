package br.com.rappidu.domain.services.impl;

import br.com.rappidu.application.dto.responses.TipoProduto;
import br.com.rappidu.domain.mappers.ProdutoMapper;
import br.com.rappidu.domain.models.Produto;
import br.com.rappidu.domain.services.ProdutoService;
import br.com.rappidu.infra.entities.ProdutoEntity;
import br.com.rappidu.infra.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repositorio;
    private final ProdutoMapper mapper;

    @Override
    public void criar(Produto produto) {
        ProdutoEntity entidade = mapper.toEntity(produto);
        repositorio.save(entidade);
    }

    @Override
    public List<Produto> buscarPorTipo(TipoProduto tipoProduto) {
        return repositorio.findByTipo(tipoProduto).stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void remover(Long id) {
        repositorio.deleteById(id);
    }


}
