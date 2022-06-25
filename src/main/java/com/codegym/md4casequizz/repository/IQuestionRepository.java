package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "call searchQuestion(:contents,:type_id,:category_id,:level_id)",nativeQuery = true)
    Iterable<Question> searchQuestion(String content,Long type_id,Long category_id, Long level_id);
    Iterable<Question> findAllByCategory(Category category);
    @Query(value = "select * from questions order by id desc limit 1",nativeQuery = true)
    Optional<Question> findNeweastQuestion();
    @Query(value = "select q.*\n" +
            "from questions q left join test_ques tq on tq.ques_id = q.id group by q.id having q.id\n" +
            " in (select ques_id from test_ques where test_id = :test_id);",nativeQuery = true)
    Iterable<Question> getListQuestionByTest(Long test_id);
}
