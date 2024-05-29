package br.com.rappidu.application.controllers;

import br.com.rappidu.application.adapters.CustomerAdapter;
import br.com.rappidu.application.dto.request.CustomerRequestDto;
import br.com.rappidu.application.dto.response.CustomerResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerAdapter adapter;

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDto> findByCpf(@PathVariable("cpf") String cpf)  {
        CustomerResponseDto response = adapter.findByCpf(cpf);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto customerRequestDto) {
       CustomerResponseDto responseDto = adapter.create(customerRequestDto);

       responseDto.add(linkTo(methodOn(CustomerController.class)
                .findByCpf(responseDto.getCpf()))
                .withSelfRel());

        return ResponseEntity.ok(responseDto);
    }
}
