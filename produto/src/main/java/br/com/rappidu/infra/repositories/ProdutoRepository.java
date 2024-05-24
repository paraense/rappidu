package br.com.rappidu.infra.repositories;

import br.com.rappidu.application.dto.responses.TipoProduto;
import br.com.rappidu.infra.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findByTipo(TipoProduto tipoProduto);
}
