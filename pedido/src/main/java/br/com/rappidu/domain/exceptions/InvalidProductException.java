package br.com.rappidu.domain.exceptions;

public class InvalidProductException extends RuntimeException {

    public InvalidProductException(String message) {
        super(message);
    }
}
