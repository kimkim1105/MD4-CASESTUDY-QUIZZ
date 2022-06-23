package com.codegym.md4casequizz.controller;


import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.service.question.IQuestionService;

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

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private ITestService testService;

    @Autowired
    private IQuestionService questionService;
    @GetMapping
    public ResponseEntity<Iterable<Question>> showListQuestion(){
        return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveQuestion(@RequestBody Question question){
        questionService.save(question);
        return new ResponseEntity<>(new ResponMessage("create success"), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable Long id) {
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(questionOptional.get().getId());
        questionService.save(question);
        return new ResponseEntity<>(new ResponMessage("update success"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable Long id) {
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Test> tests = (List<Test>) testService.findAllByQuestions(questionOptional.get());
        if (tests.size()!=0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        questionService.remove(id);
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/tests")
    public ResponseEntity<Iterable<Test>> findTestByQuestion(@PathVariable Optional<String> id) {
        Optional<Question> question = questionService.findById(Long.valueOf(id.get()));
        Iterable<Test> tests = testService.findAllByQuestions(question.get());
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }
}
