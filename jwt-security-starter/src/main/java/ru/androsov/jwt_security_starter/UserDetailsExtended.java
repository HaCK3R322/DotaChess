package ru.androsov.jwt_security_starter;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsExtended extends UserDetails {
    Object getDetails();
}
