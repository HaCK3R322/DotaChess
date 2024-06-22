package ru.androsov.rest.throwable.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String identifier;
    private final String message;

    public NotFoundException(String identifier, String message) {
        this.identifier = identifier;
        this.message = message;
    }
}
