package ru.androsov.feignclientstarter.dotachess.auth;

import feign.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.androsov.feignclientstarter.dotachess.auth.model.RegistrationRequest;
import ru.androsov.feignclientstarter.dotachess.auth.model.JwtTokenDto;
import ru.androsov.feignclientstarter.dotachess.auth.model.UserInfoDto;
import ru.androsov.rest.response.RestResponse;

public interface AuthServicePrivateApi {
    @PostMapping("/api/private/register")
    RestResponse<JwtTokenDto> register(@RequestBody RegistrationRequest request);

    @PostMapping("/api/private/get-user-details")
    RestResponse<UserInfoDto> authenticate(@RequestBody JwtTokenDto token);
}
