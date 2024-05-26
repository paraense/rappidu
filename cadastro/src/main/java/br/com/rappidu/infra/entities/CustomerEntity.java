package br.com.rappidu.infra.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "CPF", length = 11, unique = true)
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_COD")
    private List<AddressEntity> addresses = new ArrayList<>();
}
