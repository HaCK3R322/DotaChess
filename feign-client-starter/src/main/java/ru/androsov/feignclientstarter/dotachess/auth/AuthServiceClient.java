package ru.androsov.feignclientstarter.dotachess.auth;

import org.springframework.web.bind.annotation.GetMapping;

public interface AuthServiceClient {
    @GetMapping(path = "/api/private/hello")
    String getHelloFromAuthService();
}
