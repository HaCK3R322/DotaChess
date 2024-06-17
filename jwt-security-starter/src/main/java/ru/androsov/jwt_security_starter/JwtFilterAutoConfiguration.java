package ru.androsov.jwt_security_starter;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Slf4j
@RequiredArgsConstructor
@ConditionalOnClass({JwtService.class, UserDetailsExtendedService.class})
@AutoConfiguration
public class JwtFilterAutoConfiguration {
    private final UserDetailsExtendedService userDetailsExtendedService;
    private final JwtService jwtService;

    @Bean
    public JwtFilter jwtFilter() {
        log.info("Jwt filter configured");
        return new JwtFilter(jwtService, userDetailsExtendedService);
    }
}
