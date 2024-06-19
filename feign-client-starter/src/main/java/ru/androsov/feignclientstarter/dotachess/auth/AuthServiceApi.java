package ru.androsov.feignclientstarter.dotachess.auth;

import org.springframework.web.bind.annotation.GetMapping;
import ru.androsov.feignclientstarter.dotachess.auth.model.UserInfoDto;

public interface AuthServiceApi {
    @GetMapping("/api/private/jwt-to-user-details")
    UserInfoDto getUserDetails();
}
