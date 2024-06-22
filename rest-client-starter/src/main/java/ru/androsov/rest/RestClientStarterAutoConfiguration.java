package ru.androsov.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import ru.androsov.rest.throwable.handler.GlobalExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@AutoConfiguration
public class RestClientStarterAutoConfiguration {

}
