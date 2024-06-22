package ru.androsov.rest.throwable.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.Getter;
import lombok.SneakyThrows;
import ru.androsov.rest.response.RestResponse;
import ru.androsov.rest.response.component.RestError;

import java.util.List;

@Getter
public class CalledServiceException extends RuntimeException {

    private final static ObjectMapper mapper = new ObjectMapper();

    private final List<RestError> errors;

    @SneakyThrows
    public CalledServiceException(FeignException feignException) {
        this.errors = mapper.readValue(feignException.contentUTF8(), RestResponse.class).getErrors();
    }
}
