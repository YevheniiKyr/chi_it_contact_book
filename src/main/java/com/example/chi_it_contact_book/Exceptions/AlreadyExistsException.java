package com.example.chi_it_contact_book.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException {
    private static final Long serialVersionUID = 1L;


    public AlreadyExistsException(String message) {
        super(message);
    }
}