package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question,Long> {
}
