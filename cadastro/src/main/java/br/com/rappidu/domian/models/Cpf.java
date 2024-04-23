package br.com.rappidu.domian.models;


public class Cpf {

    private final String cpf;
    public Cpf(String cpfNumber) {
        // TODO Fazer validações
        this.cpf = cpfNumber;
    }

    public String get() {
        return this.cpf;
    }
}
