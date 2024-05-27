package br.com.rappidu.infra.entities;

import br.com.rappidu.application.dto.responses.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "TYPE")
    @Enumerated(EnumType.ORDINAL)
    private ProductType type;
}
