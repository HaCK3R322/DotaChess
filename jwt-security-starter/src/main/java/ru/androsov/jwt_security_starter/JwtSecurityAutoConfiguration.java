package ru.androsov.jwt_security_starter;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;


@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
@AutoConfiguration
public class JwtSecurityAutoConfiguration {
    private final JwtFilter jwtFilter;

    @PostConstruct
    public void init() {
        log.info("XDXDXD");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("Configuring security filter chain...");

        http
                .csrf(AbstractHttpConfigurer::disable);

        http
                .addFilterAfter(jwtFilter, AnonymousAuthenticationFilter.class);

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/register", "/whoami").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
