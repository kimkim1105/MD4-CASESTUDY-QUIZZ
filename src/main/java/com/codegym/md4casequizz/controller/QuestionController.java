package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.model.User;
import com.codegym.md4casequizz.service.question.IQuestionService;
import com.codegym.md4casequizz.service.test.ITestService;
import com.codegym.md4casequizz.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private ITestService testService;

    @GetMapping("/{id}/tests")
    public ResponseEntity<Iterable<Test>> findTestByQuestion(@PathVariable Optional<String> id) {
        Optional<Question> question = questionService.findById(Long.valueOf(id.get()));
        Iterable<Test> tests = testService.findAllByQuestions(question.get());
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }
}
