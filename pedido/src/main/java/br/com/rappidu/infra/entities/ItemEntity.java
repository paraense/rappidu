package br.com.rappidu.infra.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ITEMS")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CUSTOMS")
    private String customs;

    @ManyToOne
    private OrderEntity order;
}
