package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {
}
