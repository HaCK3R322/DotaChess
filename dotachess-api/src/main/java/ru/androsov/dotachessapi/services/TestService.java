package ru.androsov.dotachessapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServiceApi;

@Service
@RequiredArgsConstructor
public class TestService {
    private final AuthServiceApi authServiceApi;

    public String getHelloFromAuthService() {
        String username = authServiceApi.getUserDetails().getUsername();

        return username;
    }
}
