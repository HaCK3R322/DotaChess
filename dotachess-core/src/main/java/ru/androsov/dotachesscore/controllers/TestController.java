package ru.androsov.dotachesscore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TestController {
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping(path = "/whoami")
    public String whoami() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
