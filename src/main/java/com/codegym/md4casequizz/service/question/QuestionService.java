package com.codegym.md4casequizz.service.question;

import com.codegym.md4casequizz.model.Category;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.repository.IQuestionRepository;
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

    @Override
    public Iterable<Question> searchQuestion(String content, Long type_id, Long category_id, Long level_id) {
        return questionRepository.searchQuestion(content,type_id,category_id,level_id);
    }

    @Override
    public Iterable<Question> findAllByCategory(Category category) {
        return questionRepository.findAllByCategory(category);
    }




}
