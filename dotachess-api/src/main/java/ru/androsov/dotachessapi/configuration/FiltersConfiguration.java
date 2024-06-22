package ru.androsov.dotachessapi.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.androsov.dotachessapi.configuration.filters.JwtFilter;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServicePrivateApi;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FiltersConfiguration {

    @Configuration
    @RequiredArgsConstructor
    public static class JwtFilterConfiguration {
        private final AuthServicePrivateApi authService;

        @Bean
        public JwtFilter jwtFilter() {
            return new JwtFilter(authService);
        }
    }
}
