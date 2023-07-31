package com.lucaskaitomurakami.dellitacademy18backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String message) {
        super(message);
    }
}
