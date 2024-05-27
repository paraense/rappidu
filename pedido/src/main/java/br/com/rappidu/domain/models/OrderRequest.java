package br.com.rappidu.domain.models;

import java.util.List;

public record OrderRequest(String customerName, List<ProductRequest> products) {
}
