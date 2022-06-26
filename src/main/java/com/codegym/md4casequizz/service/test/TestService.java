package com.codegym.md4casequizz.service.test;

import com.codegym.md4casequizz.model.Level;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService implements ITestService{
    @Autowired
    ITestRepository testRepository;

    @Override
    public Iterable<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public Iterable<Test> findAllByUser(User user) {
        return testRepository.findAllByUser(user);
    }

    @Override
    public Iterable<Test> findAllByNameContaining(String name) {
        return testRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Test> findAllByLevel(Level level) {
        return testRepository.findAllByLevel(level);
    }

    @Override
    public Iterable<Test> findAllByQuestions(Question question) {
        return testRepository.findAllByQuestions(question);
    }



}
