package br.com.rappidu.domian.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
