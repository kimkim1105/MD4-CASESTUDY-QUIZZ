package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.service.answer.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private IAnswerService answerService;
    @GetMapping
    public ResponseEntity<Iterable<Answer>> showListQuestion(){
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveBlog(@RequestBody Answer answer){
        answerService.save(answer);
        return new ResponseEntity<>(new ResponMessage("create success"), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Answer> findBlogById(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(answerOptional.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Long id, @RequestBody Answer answer) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answer.setId(answerOptional.get().getId());
        answerService.save(answer);
        return new ResponseEntity<>(new ResponMessage("update success"), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Answer> deleteBlog(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answerService.remove(id);
        return new ResponseEntity<>(answerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
