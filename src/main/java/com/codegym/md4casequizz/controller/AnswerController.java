package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Result;
import com.codegym.md4casequizz.service.answer.IAnswerService;
import com.codegym.md4casequizz.service.result.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    private IAnswerService answerService;
    @Autowired
    private IResultService resultService;
    @GetMapping
    public ResponseEntity<Iterable<Answer>> showListAnswer(){
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> saveAnswer(@RequestBody Answer answer){
        answerService.save(answer);
        return new ResponseEntity<>(new ResponMessage("create success"), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Answer> findAnswerById(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(answerOptional.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answer.setId(answerOptional.get().getId());
        return new ResponseEntity<>(answerService.save(answer), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answerService.remove(id);
        return new ResponseEntity<>(answerOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/wrong")
    public ResponseEntity<Iterable<Answer>> getWrongAnswer(@PathVariable Long id) {
        Optional<Result> resultOptional = resultService.findById(id);
        if (!resultOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Long test_id = resultOptional.get().getTest().getId();
        Long result_id = resultOptional.get().getId();
        List<Answer> answers = (List<Answer>) answerService.getWrongAnswer(test_id,result_id);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/{test_id}/correct")
    public ResponseEntity<Iterable<Answer>> getListCorrectQuestionByTest(@PathVariable Optional<String> test_id) {
        Iterable<Answer> answers = answerService.getListQuestionByTest(Long.valueOf(test_id.get()));
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

}
