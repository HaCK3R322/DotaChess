package ru.androsov.dotachesscore.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import ru.androsov.jwt_security_starter.UserDetailsExtended;
import ru.androsov.jwt_security_starter.UserDetailsExtendedService;

import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsService implements UserDetailsExtendedService {
    @Override
    public UserDetailsExtended loadUserByUsername(String username) {
        return new UserDetailsExtended() {
            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public String getPassword() {
                return "";
            }

            @Override
            public String getUsername() {
                return "dictator_zx";
            }
        };
    }
}
