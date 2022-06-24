package com.codegym.md4casequizz.service.question;

import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.service.IGeneralService;

public interface IQuestionService extends IGeneralService<Question> {
    Iterable<Question> findAllByCategory(Category category);
}
