package br.com.rappidu.application.request;

import java.util.List;

public record PedidoRequest(String nome, List<ProdutosRequest> produtos) {
}
