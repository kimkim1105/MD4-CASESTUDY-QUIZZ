package com.codegym.md4casequizz.service.question;

import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.service.IGeneralService;

import java.util.Optional;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> searchQuestion(String contents,Long type_id,Long category_id, Long level_id);
    Iterable<Question> findAllByCategory(Category category);
    Optional<Question> findNeweastQuestion();

}
