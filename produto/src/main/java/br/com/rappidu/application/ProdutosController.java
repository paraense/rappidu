package br.com.rappidu.application;

import br.com.rappidu.dto.responses.ProdutoResponse;
import br.com.rappidu.dto.responses.TipoProduto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarPordutos(@RequestParam TipoProduto tipoProduto) {
        //
        return ResponseEntity.ok(Arrays.asList(new ProdutoResponse("Hamburguer", new BigDecimal("34,00"), TipoProduto.LANCHE)));
    }
}
