package br.com.rappidu.domain.models;

import br.com.rappidu.application.dto.responses.TipoProduto;

import java.math.BigDecimal;

public record Produto(String nome,
                      BigDecimal valor,
                      TipoProduto tipo) {
}
