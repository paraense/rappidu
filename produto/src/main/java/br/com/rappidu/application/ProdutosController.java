package br.com.rappidu.application;

import br.com.rappidu.application.dto.request.ProdutoRequest;
import br.com.rappidu.application.dto.responses.ProdutoResponse;
import br.com.rappidu.application.dto.responses.TipoProduto;
import br.com.rappidu.domain.mappers.ProdutoMapper;
import br.com.rappidu.domain.models.Produto;
import br.com.rappidu.domain.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutosController {

    private final ProdutoMapper mapper;

    private final ProdutoService service;


    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar(@RequestParam TipoProduto tipoProduto) {
        var x = service.buscarPorTipo(tipoProduto);
        return ResponseEntity.ok(x.stream().map(mapper::toResponse).collect(Collectors.toList()));

    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody ProdutoRequest produtoRequest){
        Produto produto = mapper.toModel(produtoRequest);
        service.criar(produto);
        return new ResponseEntity<>("Produto Cadastrado", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover (@PathVariable Long id){
        service.remover(id);
        return new ResponseEntity<>("Produto Removido", HttpStatus.OK);
    }
}
