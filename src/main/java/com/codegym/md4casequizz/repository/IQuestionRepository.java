package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "call searchQuestion(:contents,:type_id,:category_id,:level_id)",nativeQuery = true)
    Iterable<Question> searchQuestion(String content,Long type_id,Long category_id, Long level_id);
}
