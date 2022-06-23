package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILevelRepository extends JpaRepository<Level, Long> {
}
