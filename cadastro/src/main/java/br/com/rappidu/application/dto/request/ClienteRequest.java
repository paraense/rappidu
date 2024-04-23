package br.com.rappidu.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ClienteRequest {
    private Long id;

    private String name;

    private String cpf;

    private List<EnderecoRequest> enderecos = new ArrayList<>();
}
