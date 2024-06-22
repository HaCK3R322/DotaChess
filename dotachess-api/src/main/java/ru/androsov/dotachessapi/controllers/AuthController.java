package ru.androsov.dotachessapi.controllers;

import feign.FeignException;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServicePrivateApi;
import ru.androsov.feignclientstarter.dotachess.auth.model.JwtTokenDto;
import ru.androsov.feignclientstarter.dotachess.auth.model.RegistrationRequest;
import ru.androsov.feignclientstarter.dotachess.auth.model.UserInfoDto;
import ru.androsov.rest.response.RestResponse;
import ru.androsov.rest.throwable.exception.CalledServiceException;

@RestController
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/public")
public class AuthController {
    private final AuthServicePrivateApi authService;

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        try {
            JwtTokenDto response = authService.register(request).getResult();
            return ResponseEntity.ok(response);
        } catch (FeignException e) {
            throw new CalledServiceException(e);
        }
    }
}
