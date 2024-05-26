package br.com.rappidu.application.dto.request;

import br.com.rappidu.application.dto.responses.ProductType;

import java.math.BigDecimal;

public record ProductRequest(String name,
                             BigDecimal price,
                             ProductType type) {
}
