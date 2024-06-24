package br.com.rappidu.application.dto.request;


import java.math.BigDecimal;

public record ProductRequest(String name,
                             BigDecimal price,
                             Integer type) {
}
