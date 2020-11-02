package com.spring.app.service;

import com.spring.app.entity.User;
import com.spring.app.model.Message;

import java.util.List;

public interface UserService {
    User create(User user);

    User update(int id, User user);

    List<User> findAll();

    User findUserByUsername(String username);

    void delete(int id);

    Message registerUser(User user);
}
