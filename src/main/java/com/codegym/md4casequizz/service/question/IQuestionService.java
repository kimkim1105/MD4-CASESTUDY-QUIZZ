package com.codegym.md4casequizz.service.question;

import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.service.IGeneralService;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> searchQuestion(String contents,Long type_id,Long category_id, Long level_id);
}
