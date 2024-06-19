package ru.androsov.dotachessapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServiceClient;

@Service
@RequiredArgsConstructor
public class TestService {
    private final AuthServiceClient authServiceClient;

    public String getHelloFromAuthService() {
        return authServiceClient.getHelloFromAuthService();
    }
}
