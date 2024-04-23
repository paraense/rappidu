package br.com.rappidu.infra.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD")
    private Long id;

    @Column(name = "NOME", length = 50)
    private String name;

    @Column(name = "CPF", length = 11, unique = true)
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENTE_ID")
    private List<EnderecoEntity> enderecos = new ArrayList<>();
}
