package com.kmusau.dockercontainers.services;

import com.kmusau.dockercontainers.models.UsersEntity;
import com.kmusau.dockercontainers.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersEntity createUser(UsersEntity user) {
        user.setDateCreated(new Date());
        user.setDateModified(new Date());
        return usersRepository.save(user);
    }

    public UsersEntity updateUser(UsersEntity users, Integer userId) {
        var existingUser = usersRepository.findById(userId).get();

        if (Objects.nonNull(users.getFirstName())) {
            existingUser.setFirstName(users.getFirstName());
        }
        if (Objects.nonNull(users.getLastName())) {
            existingUser.setLastName(users.getLastName());
        }
        if (users.getAge() != 0) {
            existingUser.setAge(users.getAge());
        }

        existingUser.setDateModified(new Date());

        return usersRepository.save(existingUser);
    }

    public String deleteUser(Integer userId) {
        var user = usersRepository.findById(userId).get();
        var userFullName = user.getFirstName()+ " "+user.getLastName();
        usersRepository.deleteById(userId);
        return "User "+ userFullName +" deleted successfully";
    }
}
