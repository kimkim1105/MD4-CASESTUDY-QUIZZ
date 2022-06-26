package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Result;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepository extends JpaRepository<Result, Long> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);
}
