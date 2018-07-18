package com.thymeleaf.demo.Repositories;

import com.thymeleaf.demo.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
