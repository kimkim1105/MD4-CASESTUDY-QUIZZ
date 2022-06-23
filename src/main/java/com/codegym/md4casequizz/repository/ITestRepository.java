package com.codegym.md4casequizz.repository;

import com.codegym.md4casequizz.model.Level;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<Test, Long> {
    Iterable<Test> findAllByUser (User user);
    Iterable<Test> findAllByNameContaining(String name);
    Iterable<Test> findAllByLevel (Level level);
<<<<<<< HEAD
=======
    Iterable<Test> findAllByQuestions (Question question);
>>>>>>> 2979f2aec8b528307f62a67f2ba916238f45d963
}
