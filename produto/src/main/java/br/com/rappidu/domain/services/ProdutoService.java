package br.com.rappidu.domain.services;

import br.com.rappidu.application.dto.responses.TipoProduto;
import br.com.rappidu.domain.models.Produto;

import java.util.List;

public interface ProdutoService {
    void criar(Produto produto);

    List<Produto> buscarPorTipo(TipoProduto tipoProduto);

    void remover(Long id);

}
