package br.com.rappidu.application.dto.request;

import java.util.List;

public record OrderRequestDto(String customerName, List<ProductRequestDto> products) {
}
