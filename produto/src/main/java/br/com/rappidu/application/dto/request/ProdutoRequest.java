package br.com.rappidu.application.dto.request;

import br.com.rappidu.application.dto.responses.TipoProduto;

import java.math.BigDecimal;

public record ProdutoRequest(String nome, BigDecimal valor, TipoProduto tipo) {
}
