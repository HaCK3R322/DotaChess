package ru.androsov.jwt_security_starter;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsExtendedService {
    UserDetailsExtended loadUserByUsername(String username);
}
