package ru.androsov.dotachess_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class DotachessAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotachessAuthApplication.class, args);
	}
}
