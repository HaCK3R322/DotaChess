package ru.androsov.jwt_security_starter;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@ConditionalOnBean({UserDetailsExtendedService.class, JwtService.class})
@Slf4j
public class JwtSecurityAutoConfiguration {
    private final UserDetailsExtendedService userDetailsExtendedService;
    private final JwtService jwtService;

    @PostConstruct
    public void init() {
        log.info("JwtSecurityAutoConfiguration builded.");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);

        http
                .addFilterBefore(new JwtFilter(jwtService, userDetailsExtendedService), BasicAuthenticationFilter.class);

        return http.build();
    }
}
