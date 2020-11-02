package com.spring.app.service.impl;

import com.spring.app.entity.Role;
import com.spring.app.entity.RoleType;
import com.spring.app.entity.User;
import com.spring.app.model.Message;
import com.spring.app.model.MessageType;
import com.spring.app.repository.RoleRepository;
import com.spring.app.repository.UserRepository;
import com.spring.app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /**
     * Constructor
     * @param userRepository
     * @param roleRepository
     */
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    @Override
    public Message registerUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()){
            String message = "Username đã được sử dụng!";
            return new Message(MessageType.ERROR, message);
        }

        if (userRepository.findUserByEmail(user.getEmail()).isPresent()){
            String message = "Email đã được sử dụng!";
            return new Message(MessageType.ERROR, message);
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());

        /**
         * will change by encode password
         */
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setActive(false);

        Optional<Role> optRole = roleRepository.findRoleByRole(RoleType.ROLE_USER);
        Role role = optRole.orElseGet(() -> {
           Role result = new Role();
           result.setRole(RoleType.ROLE_USER);
           return result;
        });
        newUser.setRoles(Set.of(role));

        this.create(newUser);
        String message = "Kiểm tra email để kích hoạt tài khoản!";
        return new Message(MessageType.SUCCESS, message);
    }
}
