package com.codegym.md4casequizz.service.test;

import com.codegym.md4casequizz.model.Level;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.service.IGeneralService;

public interface ITestService extends IGeneralService<Test> {
    Iterable<Test> findAllByUser (User user);
    Iterable<Test> findAllByNameContaining(String name);
    Iterable<Test> findAllByLevel (Level level);
}
