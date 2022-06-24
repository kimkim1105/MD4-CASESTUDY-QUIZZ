package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Level;
import com.codegym.md4casequizz.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Long> {
}
