package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    @GetMapping
    public ResponseEntity<Iterable<Question>> showListQuestion(){
        return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveBlog(@RequestBody Question blog){
        return new ResponseEntity<>(new ResponMessage("create success"), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Question> findBlogById(@PathVariable Long id) {
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.OK);
    }
}
