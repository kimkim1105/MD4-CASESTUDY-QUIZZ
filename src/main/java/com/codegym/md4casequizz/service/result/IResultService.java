package com.codegym.md4casequizz.service.result;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Result;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.service.IGeneralService;

public interface IResultService extends IGeneralService<Result> {
    Iterable<Result> findAllByUser (User user);
    Iterable<Result> findAllByTest (Test test);

}
