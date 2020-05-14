package br.dazzi.AM53.domain.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends APIException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), message);
    }
}
