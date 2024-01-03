package com.kmusau.dockercontainers.repository;

import com.kmusau.dockercontainers.models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
}
