package com.codegym.md4casequizz.service.question;

import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.repository.IQuestionRepository;
import com.codegym.md4casequizz.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question question) {
       return questionRepository.save(question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }
}
