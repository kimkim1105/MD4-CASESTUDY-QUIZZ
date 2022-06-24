package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
