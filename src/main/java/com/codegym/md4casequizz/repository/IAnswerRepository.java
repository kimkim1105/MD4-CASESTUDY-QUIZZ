package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer,Long> {
    Iterable<Answer> findAllByQuestion(Question question);
    @Query(value = "select a.* from answers a where a.status = true \n" +
            "and a.question_id in (select q.id from questions q where q.id\n" +
            "in (select tq.ques_id from test_ques tq where tq.test_id = :test_id)) and a.id \n" +
            "not in (select ra.answer_id from result_answer ra where ra.result_id = :result_id) group by a.question_id",nativeQuery = true)
    Iterable<Answer> getWrongAnswer(Long test_id, Long result_id);
}
