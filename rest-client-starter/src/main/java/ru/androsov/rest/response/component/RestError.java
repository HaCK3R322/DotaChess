package ru.androsov.rest.response.component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public final class RestError {

    private String identifier;
    private String message;

    public RestError(String identifier, String message) {
        this.identifier = identifier;
        this.message = message;
    }
}
