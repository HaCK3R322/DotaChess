package ru.androsov.dotachess_auth.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.androsov.dotachess_auth.model.entities.UserEntity;
import ru.androsov.dotachess_auth.services.JwtService;
import ru.androsov.dotachess_auth.services.UserService;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServicePrivateApi;
import ru.androsov.feignclientstarter.dotachess.auth.model.RegistrationRequest;
import ru.androsov.feignclientstarter.dotachess.auth.model.JwtTokenDto;
import ru.androsov.feignclientstarter.dotachess.auth.model.UserInfoDto;
import ru.androsov.rest.response.RestResponse;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PrivateController implements AuthServicePrivateApi {
    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping("/api/private/register")
    public RestResponse<JwtTokenDto> register(@RequestBody RegistrationRequest request) {
        UserEntity user = userService.createUser(request);
        String token = jwtService.generateToken(user.getId());
        JwtTokenDto jwtTokenDto = new JwtTokenDto(token);

        return RestResponse.success(jwtTokenDto);
    }

    @PostMapping("/api/private/get-user-details")
    public RestResponse<UserInfoDto> authenticate(JwtTokenDto token) {
        return RestResponse.success(jwtService.parse(token.getToken()));
    }
}