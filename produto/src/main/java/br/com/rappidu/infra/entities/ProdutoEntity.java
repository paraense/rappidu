package br.com.rappidu.infra.entities;

import br.com.rappidu.application.dto.responses.TipoProduto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME", length = 50)
    private String nome;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "TIPO")
    @Enumerated(EnumType.ORDINAL)
    private TipoProduto tipo;
}
