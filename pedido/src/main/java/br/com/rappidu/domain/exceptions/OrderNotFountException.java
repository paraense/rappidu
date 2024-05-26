package br.com.rappidu.domain.exceptions;

public class OrderNotFountException extends RuntimeException {

    public OrderNotFountException(String message) {
        super(message);
    }
}
