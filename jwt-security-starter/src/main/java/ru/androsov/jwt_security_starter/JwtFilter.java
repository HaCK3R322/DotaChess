package ru.androsov.jwt_security_starter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsExtendedService userDetailsExtendedService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String requestUri = request.getRequestURI();

        String token = request.getHeader("Authorization");
        log.info("GOT REQUEST!!!");

        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);

            // Perform JWT validation logic here
            if (jwtService.isValid(jwt)) {

                String username = jwtService.parseUsername(jwt);
                UserDetailsExtended user = userDetailsExtendedService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        "[PROTECTED]",
                        user.getAuthorities()
                );
                authentication.setDetails(user.getDetails());

                SecurityContextHolder.getContext().setAuthentication(authentication);

                chain.doFilter(request, response);
                return;
            }
        }

        log.info("Got invalid jwt in request.");
        chain.doFilter(request, response);
    }
}