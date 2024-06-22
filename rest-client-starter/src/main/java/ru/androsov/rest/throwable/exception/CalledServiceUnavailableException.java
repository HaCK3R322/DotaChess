package ru.androsov.rest.throwable.exception;

import lombok.Getter;

@Getter
public class CalledServiceUnavailableException extends RuntimeException {
    private final String identifier;
    private final String message;

    public CalledServiceUnavailableException(String identifier, String message) {
        this.identifier = identifier;
        this.message = message;
    }
}
