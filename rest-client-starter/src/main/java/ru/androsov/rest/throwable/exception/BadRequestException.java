package ru.androsov.rest.throwable.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final String identifier;
    private final String message;

    public BadRequestException(String identifier, String message) {
        this.identifier = identifier;
        this.message = message;
    }
}
