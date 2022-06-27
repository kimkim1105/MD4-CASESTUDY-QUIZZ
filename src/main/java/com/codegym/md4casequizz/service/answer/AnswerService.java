package com.codegym.md4casequizz.service.answer;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Question;
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

    @Override
    public Iterable<Answer> findAllByQuestion(Question question) {
        return answerRepository.findAllByQuestion(question);
    }
    @Override
    public Iterable<Answer> getWrongAnswer(Long test_id, Long result_id) {
        return answerRepository.getWrongAnswer(test_id, result_id);
    }

    @Override
    public Iterable<Answer> getListQuestionByTest(Long test_id) {
        return answerRepository.getListQuestionByTest(test_id);
    }
}
