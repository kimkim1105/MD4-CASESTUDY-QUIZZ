package com.codegym.md4casequizz.service.answer;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.repository.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);
    }
}
