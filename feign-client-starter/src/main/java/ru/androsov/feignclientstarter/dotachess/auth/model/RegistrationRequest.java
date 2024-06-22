package ru.androsov.feignclientstarter.dotachess.auth.model;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String password;
}
