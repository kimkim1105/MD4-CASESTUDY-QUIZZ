package com.codegym.md4casequizz.service.answer;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.service.IGeneralService;

public interface IAnswerService extends IGeneralService<Answer> {
    Iterable<Answer> findAllByQuestion(Question question);

}
