package com.spring.app.service.impl;

import com.spring.app.entity.User;
import com.spring.app.repository.UserRepository;
import com.spring.app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    /**
     *
     * @param userRepository
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(int id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow();
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
