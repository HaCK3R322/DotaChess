package ru.androsov.dotachesscore.services;

import org.springframework.stereotype.Service;
import ru.androsov.jwt_security_starter.UserDetailsExtended;
import ru.androsov.jwt_security_starter.UserDetailsExtendedService;

@Service
public class UserDetailsService implements UserDetailsExtendedService {
    @Override
    public UserDetailsExtended loadUserByUsername(String username) {
        return null;
    }
}
