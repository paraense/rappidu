package br.com.rappidu.infra.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "ENDERECOS")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGRADOURO", length = 100)
    private String logradouro;

    @Column(name = "BAIRRO",length = 50)
    private String bairro;

    @Column(name = "CIDADE", length = 50)
    private String cidade;

    @Column(name = "ESTADO", length = 20)
    private String estado;

    @Column(name = "CEP", length = 7)
    private String cep;

    @ManyToOne
    private ClienteEntity cliente;

}
