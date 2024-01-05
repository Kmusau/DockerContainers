package com.kmusau.dockercontainers.controller;

import com.kmusau.dockercontainers.models.UsersEntity;
import com.kmusau.dockercontainers.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public String welcome() {
        return "Welcome, Here goes my first docker image container";
    }

    @GetMapping("/users")
    public List<UsersEntity> allUsers() {
        return usersRepository.findAll();
    }

    @PostMapping("/create/user")
    public UsersEntity createUser(@RequestBody UsersEntity user) {
        return usersRepository.save(user);
    }
}
