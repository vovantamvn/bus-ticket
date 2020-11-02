package com.spring.app.repository;

import com.spring.app.entity.Role;
import com.spring.app.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * Find a role by role type
     * @param type
     * @return Optional<Role>
     */
    Optional<Role> findRoleByRole(RoleType type);
}
