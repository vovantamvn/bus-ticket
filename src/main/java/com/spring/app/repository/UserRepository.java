package com.spring.app.repository;

import com.spring.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    /*
    find a user by username
     */
    Optional<User> findUserByUsername(String username);
}
