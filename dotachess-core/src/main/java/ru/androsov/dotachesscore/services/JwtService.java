package ru.androsov.dotachesscore.services;

import org.springframework.stereotype.Service;

@Service
public class JwtService implements ru.androsov.jwt_security_starter.JwtService {
    @Override
    public boolean isValid(String jwt) {
        return false;
    }

    @Override
    public String parseUsername(String jwt) {
        return "";
    }
}
