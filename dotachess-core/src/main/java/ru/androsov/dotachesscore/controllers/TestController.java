package ru.androsov.dotachesscore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/private")
public class TestController {

    @GetMapping("/hello")
    public String helloFromPrivate() {
        return "Hello from private method";
    }
}
