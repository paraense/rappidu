package br.com.rappidu.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDto {

    private String street;

    private String neighborhood;

    private String city;

    private String state;

    private String zipcode;
}
