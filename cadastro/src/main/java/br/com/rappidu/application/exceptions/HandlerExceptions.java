package br.com.rappidu.application.exceptions;

import br.com.rappidu.domain.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandlerExceptions {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<ErrorMessageModel> customerNotFound(CustomerNotFoundException ex) {
          return ResponseEntity.ofNullable(new ErrorMessageModel(ex.getMessage()));
    }
}
