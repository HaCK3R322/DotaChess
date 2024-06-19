package ru.androsov.dotachessapi.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.androsov.dotachessapi.services.TestService;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping(path = "/api/public/hello-auth")
    public String publicMethod() {
        return testService.getHelloFromAuthService();
    }
}
