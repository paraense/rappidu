package br.com.rappidu.application.dto.responses;

import lombok.Data;

import java.math.BigDecimal;


public record ProductResponse(Long code,
                              String name,
                              BigDecimal price,
                              ProductType type) {

}
