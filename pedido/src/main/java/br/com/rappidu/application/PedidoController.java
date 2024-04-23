package br.com.rappidu.application;


import br.com.rappidu.application.request.PedidoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @PostMapping
    public ResponseEntity<URI> criarPedido(@RequestBody PedidoRequest pedidoRequest) {
        Long cod = 1L;
        return ResponseEntity.created(URI.create("/pagamento/qrCode" + cod)).build();
    }
}
