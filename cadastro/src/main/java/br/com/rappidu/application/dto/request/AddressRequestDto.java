package br.com.rappidu.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDto {

    private String logradouro;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
