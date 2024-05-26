package br.com.rappidu.application.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class CustomerResponseDto extends RepresentationModel<CustomerResponseDto> {

    private Long id;

    private String name;

    private String cpf;

    private List<AddressResponseDto> addresses = new ArrayList<>();
}
