package com.kmusau.dockercontainers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String welcome() {
        return "Welcome, Here goes my first docker image container";
    }
}
