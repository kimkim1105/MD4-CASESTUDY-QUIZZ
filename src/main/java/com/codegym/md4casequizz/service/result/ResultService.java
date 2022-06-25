package com.codegym.md4casequizz.service.result;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Result;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.repository.IResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultService implements IResultService{
    @Autowired
    IResultRepository resultRepository;


    @Override
    public Iterable<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        resultRepository.deleteById(id);
    }

    @Override
    public Iterable<Result> findAllByUser(User user) {
        return resultRepository.findAllByUser(user);
    }

    @Override
    public Iterable<Result> findAllByTest(Test test) {
        return resultRepository.findAllByTest(test);
    }


}
