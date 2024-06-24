package br.com.rappidu.domain.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
         super(message);
    }
}
