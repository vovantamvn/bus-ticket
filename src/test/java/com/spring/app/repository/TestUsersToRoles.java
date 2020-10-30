package com.spring.app.repository;

import com.spring.app.entity.Role;
import com.spring.app.entity.RoleType;
import com.spring.app.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestUsersToRoles {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testUserHasManyRole() {
        Role roleAdmin = new Role();
        roleAdmin.setRole(RoleType.ROLE_ADMIN);

        Role roleUser = new Role();
        roleUser.setRole(RoleType.ROLE_USER);

        Set<Role> roles = Set.of(roleUser, roleAdmin);

        User userAdmin = new User();
        userAdmin.setPassword("123456");
        userAdmin.setUsername("name");
        userAdmin.setRoles(roles);

        roleUser.setUsers(Set.of(userAdmin));
        roleAdmin.setUsers(Set.of(userAdmin));

        userRepository.save(userAdmin);

        User result = userRepository.findById(userAdmin.getId()).orElseThrow();

        assertEquals(result.getRoles().size(), 2);
    }
}
