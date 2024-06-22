package ru.androsov.dotachess_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.androsov.rest.throwable.handler.GlobalExceptionHandler;

@SpringBootApplication
@Import(GlobalExceptionHandler.class)
public class DotachessAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotachessAuthApplication.class, args);
	}

}
