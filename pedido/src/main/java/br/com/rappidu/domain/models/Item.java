package br.com.rappidu.domain.models;
import java.math.BigDecimal;

public record Item(Long code, String name, BigDecimal amount, String customs) {
}
