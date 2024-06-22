package ru.androsov.dotachessapi.configuration.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServicePrivateApi;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final static String AUTHORIZATION_HEADER = "Authorization";
    private final AuthServicePrivateApi authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean isHeaderPresent = request.getHeader(AUTHORIZATION_HEADER) != null;

        if(!isHeaderPresent) filterChain.doFilter(request, response);

        // try some shit))
        log.info(request.getHeader(AUTHORIZATION_HEADER));

        filterChain.doFilter(request, response);
    }
}
