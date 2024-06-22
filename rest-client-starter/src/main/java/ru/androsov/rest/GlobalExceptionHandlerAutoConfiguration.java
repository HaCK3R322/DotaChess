package ru.androsov.rest;

import org.springframework.context.annotation.*;
import ru.androsov.rest.throwable.handler.GlobalExceptionHandler;

@Configuration
public class GlobalExceptionHandlerAutoConfiguration {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
