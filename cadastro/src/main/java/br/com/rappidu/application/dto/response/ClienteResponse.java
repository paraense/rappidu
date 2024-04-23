package br.com.rappidu.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ClienteResponse {
    private Long id;

    private String name;

    private String cpf;

    private List<EnderecoResponse> enderecos = new ArrayList<>();
}
