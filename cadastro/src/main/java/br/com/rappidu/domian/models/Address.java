package br.com.rappidu.domian.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String street;

    private String neighborhood;

    private String city;

    private String state;

    private String zipcode;
}
