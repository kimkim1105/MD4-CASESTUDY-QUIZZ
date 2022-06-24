package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer,Long> {
    Iterable<Answer> findAllByQuestion(Question question);
}
