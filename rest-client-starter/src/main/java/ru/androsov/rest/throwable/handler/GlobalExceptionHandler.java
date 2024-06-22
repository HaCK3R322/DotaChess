package ru.androsov.rest.throwable.handler;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.androsov.rest.response.RestResponse;
import ru.androsov.rest.response.component.RestError;
import ru.androsov.rest.throwable.exception.BadRequestException;
import ru.androsov.rest.throwable.exception.CalledServiceException;
import ru.androsov.rest.throwable.exception.CalledServiceUnavailableException;
import ru.androsov.rest.throwable.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> handleBadRequestException(BadRequestException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestResponse.error(List.of(new RestError(ex.getIdentifier(), ex.getMessage()))));
    }

    @ExceptionHandler({CalledServiceException.class})
    public ResponseEntity<?> handleCalledServiceException(CalledServiceException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestResponse.error(ex.getErrors()));
    }

    @ExceptionHandler({CalledServiceUnavailableException.class})
    public ResponseEntity<?> handleCalledServiceUnavailableException(CalledServiceUnavailableException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResponse.error(List.of(new RestError(ex.getIdentifier(), ex.getMessage()))));
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(RestResponse.error(List.of(new RestError(ex.getIdentifier(), ex.getMessage()))));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestResponse.error(getErrorBody(ex.getBindingResult())));
    }

    private List<RestError> getErrorBody(BindingResult bindingResult) {
        return bindingResult
                .getAllErrors()
                .stream()
                .map(el -> new RestError(((DefaultMessageSourceResolvable) el.getArguments()[0]).getDefaultMessage(), el.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
