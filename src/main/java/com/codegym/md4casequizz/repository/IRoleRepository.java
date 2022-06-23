package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Role;
import com.codegym.md4casequizz.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName name);
}
