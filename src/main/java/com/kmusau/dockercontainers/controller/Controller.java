package com.kmusau.dockercontainers.controller;

import com.kmusau.dockercontainers.models.UsersEntity;
import com.kmusau.dockercontainers.repository.UsersRepository;
import com.kmusau.dockercontainers.services.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final UsersRepository usersRepository;
    private final UsersService usersService;

    public Controller(UsersRepository usersRepository, UsersService usersService) {
        this.usersRepository = usersRepository;
        this.usersService = usersService;
    }


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
        return usersService.createUser(user);
    }

    @PutMapping("/edit/user/{userId}")
    public UsersEntity updateUser(@RequestBody UsersEntity users, @PathVariable Integer userId) {
        return usersService.updateUser(users, userId);
    }

    @DeleteMapping("/delete/user/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        return usersService.deleteUser(userId);
    }
}
