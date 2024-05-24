package br.com.rappidu.application.dto.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoResponse {
    private final String nome;
    private final BigDecimal valor;
    private final TipoProduto tipo;
}
