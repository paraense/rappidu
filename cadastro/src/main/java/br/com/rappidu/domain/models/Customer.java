package br.com.rappidu.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Customer {
    private Long id;

    private String name;

    private Cpf cpf;

    private List<Address> addresses = new ArrayList<>();

    public void setCpf(String documentNumber) {
        this.cpf = new Cpf(documentNumber);
    }

    public String getCpf() {
        return this.cpf.get();
    }
}
