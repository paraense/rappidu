package br.com.rappidu.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @GetMapping("/qrcode/{codPedido}")
    public ResponseEntity<?> obterQrCodeDePagamento(@PathVariable Long codPedido) {
        // Devolve QRCode de pagamento
        return ResponseEntity.ok().build();
    }

}
