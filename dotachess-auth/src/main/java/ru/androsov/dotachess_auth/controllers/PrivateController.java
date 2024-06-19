package ru.androsov.dotachess_auth.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/private")
public class PrivateController {
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello from AUTHENTICATION-SERVICE private controller!";
    }
}
