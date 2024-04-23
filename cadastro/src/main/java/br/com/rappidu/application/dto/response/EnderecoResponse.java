package br.com.rappidu.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponse {

    private String logradouro;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
