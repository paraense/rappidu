package br.com.rappidu.domain.models;

import br.com.rappidu.application.dto.responses.ProductType;

import java.math.BigDecimal;

public record Product(String name,
                      BigDecimal price,
                      ProductType type) {
}
