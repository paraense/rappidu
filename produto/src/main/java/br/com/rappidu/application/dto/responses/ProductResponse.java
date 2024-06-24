package br.com.rappidu.application.dto.responses;

import java.math.BigDecimal;


public record ProductResponse(Long code,
                              String name,
                              BigDecimal price,
                              String type) {

}
