package br.com.rappidu.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDto {

    private String street;

    private String neighborhood;

    private String city;

    private String state;

    private String zipcode;
}
