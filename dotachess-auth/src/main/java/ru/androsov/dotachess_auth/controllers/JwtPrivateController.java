package ru.androsov.dotachess_auth.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.androsov.feignclientstarter.dotachess.auth.AuthServiceApi;
import ru.androsov.feignclientstarter.dotachess.auth.model.UserInfoDto;

@Slf4j
@RestController
@CrossOrigin
public class JwtPrivateController implements AuthServiceApi {

    @Override
    public UserInfoDto getUserDetails() {
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(1L);
        userInfoDto.setUsername("dictator_zx_mock");

        return userInfoDto;
    }
}