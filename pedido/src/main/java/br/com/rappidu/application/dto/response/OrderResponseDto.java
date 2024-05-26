package br.com.rappidu.application.dto.response;

import br.com.rappidu.domain.models.StatusOrder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Getter
public class OrderResponseDto extends RepresentationModel<OrderResponseDto> {

    private final Long code;
    private final String customerName;
    private final BigDecimal amount;
    private final StatusOrder status;

    public OrderResponseDto(Long code, String customerName, BigDecimal amount, StatusOrder status) {
        this.code = code;
        this.amount = amount;
        this.status = status;
        this.customerName = customerName;
    }
}
