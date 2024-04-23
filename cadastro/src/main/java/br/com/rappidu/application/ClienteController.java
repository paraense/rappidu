package br.com.rappidu.application;

import br.com.rappidu.application.dto.request.ClienteRequest;
import br.com.rappidu.application.dto.response.ClienteResponse;
import br.com.rappidu.domian.mappers.ClienteMapper;
import br.com.rappidu.domian.models.Cliente;
import br.com.rappidu.domian.models.Cpf;
import br.com.rappidu.domian.services.ClienteService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;
    private final ClienteMapper mapper;

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> buscarPorCpf(@PathVariable("cpf") Cpf cpf) throws ChangeSetPersister.NotFoundException {
        Cliente cliente = service.buscarPorCpf(cpf);
        ClienteResponse response = mapper.toResponseDTO(cliente);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<URI> cadastrar(@RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = mapper.toModel(clienteRequest);
        Long id = service.criar(cliente);
        return ResponseEntity.created(URI.create("/clientes/" + id)).build();
    }
}
