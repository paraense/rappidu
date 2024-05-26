package br.com.rappidu.domian.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
         super(message);
    }
}
