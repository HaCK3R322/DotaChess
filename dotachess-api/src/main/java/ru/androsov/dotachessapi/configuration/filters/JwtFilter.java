package ru.androsov.dotachessapi.configuration.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServiceApi;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final static String AUTHORIZATION_HEADER = "Authorization";
    private final AuthServiceApi authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getHeader(AUTHORIZATION_HEADER) != null) {
            log.info("PSEUDO JWT FILTER INTERCEPTION");
        } else {
            log.info("NO JWT FOUND!");
        }

        filterChain.doFilter(request, response);
    }
}
