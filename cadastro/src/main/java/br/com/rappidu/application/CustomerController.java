package br.com.rappidu.application;

import br.com.rappidu.application.dto.request.CustomerRequestDto;
import br.com.rappidu.application.dto.response.CustomerResponseDto;
import br.com.rappidu.domian.mappers.CustomerMapper;
import br.com.rappidu.domian.models.Customer;
import br.com.rappidu.domian.models.Cpf;
import br.com.rappidu.domian.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;
    private final CustomerMapper mapper;

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDto> findByCpf(@PathVariable("cpf") Cpf cpf) throws ChangeSetPersister.NotFoundException {
        Customer customer = service.findByCpf(cpf);
        CustomerResponseDto response = mapper.toResponseDTO(customer);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<URI> create(@RequestBody CustomerRequestDto customerRequestDto) {
        Customer customer = mapper.toModel(customerRequestDto);
        Long id = service.criar(customer);
        return ResponseEntity.created(URI.create("/customer/" + id)).build();
    }
}
