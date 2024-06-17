package ru.androsov.dotachesscore.configurations;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.savedrequest.RequestCacheAwareFilter;
import ru.androsov.jwt_security_starter.JwtFilter;

//@Slf4j
//@RequiredArgsConstructor
//@EnableWebSecurity(debug = true)
//@Configuration
//public class JwtSecurityAutoConfiguration {
//    private final JwtFilter jwtFilter;
//
//    @PostConstruct
//    public void init() {
//        log.info("JwtSecurityAutoConfiguration builded.");
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        log.info("Configuring security filter chain...");
//
//        http
//                .csrf(AbstractHttpConfigurer::disable);
//
//        http
//                .addFilterBefore(jwtFilter, AnonymousAuthenticationFilter.class);
//
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/login", "/register", "/whoami").permitAll()
//                        .anyRequest().authenticated()
//                );
//
//        return http.build();
//    }
//}