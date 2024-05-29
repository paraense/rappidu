package br.com.rappidu.application.controllers;


import br.com.rappidu.application.adapters.OrderAdapter;
import br.com.rappidu.application.dto.request.OrderRequestDto;
import br.com.rappidu.application.dto.response.OrderResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderAdapter adapter;

    // TODO Aplicar paginação
    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> findAll() {
        return ResponseEntity.ok(adapter.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderResponseDto> newOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto orderResponseDto = adapter.create(orderRequestDto);

        orderResponseDto.add(linkTo(methodOn(OrderController.class)
                .pay(orderResponseDto.getCode()))
                .withSelfRel());

        return ResponseEntity.ofNullable(orderResponseDto);
    }

    @PostMapping("/{code}/pay")
    public ResponseEntity<?> pay(Long code) {
        OrderResponseDto responseDto = adapter.pay(code);

        responseDto.add(linkTo(methodOn(OrderController.class)
                .findByCode(responseDto.getCode()))
                .withSelfRel());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{code}")
    public ResponseEntity<OrderResponseDto> findByCode(@PathVariable Long code) {
        OrderResponseDto orderResponseDto = adapter.findByCode(code);
        return ResponseEntity.ok(orderResponseDto);
    }
}
