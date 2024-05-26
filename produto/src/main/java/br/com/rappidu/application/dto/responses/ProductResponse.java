package br.com.rappidu.application.dto.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private final String name;
    private final BigDecimal price;
    private final ProductType type;
}
