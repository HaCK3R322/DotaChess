package ru.androsov.jwt_security_starter;

import org.springframework.stereotype.Service;

public interface JwtService {
    boolean isValid(String jwt);
    String parseUsername(String jwt);
}
