package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.model.Answer;
import com.codegym.md4casequizz.model.Result;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.service.answer.AnswerService;
import com.codegym.md4casequizz.service.result.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/results")
public class ResultController {
    @Autowired
    IResultService resultService;
    @Autowired
    AnswerService answerService;

    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        resultService.save(result);
        result.setDate(new Date());
        result.getTest().getQuestions();
        Integer maxMark = result.getAnswers().size();
        Integer wrong = ((List<Answer>) answerService.getWrongAnswer(result.getTest().getId(), result.getId())).size();
        result.setMark(maxMark - wrong);
        return new ResponseEntity<>(resultService.save(result), HttpStatus.CREATED);
    }
    @GetMapping
    public  ResponseEntity<Iterable<Result>> getAllResult(){
        return new ResponseEntity<>(resultService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Result> getResultById(@PathVariable Long id){
        return new ResponseEntity<>(resultService.findById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id) {
        Optional<Result> resultOptional = resultService.findById(id);
        if (!resultOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        resultService.remove(id);
        return new ResponseEntity<>(resultOptional.get(), HttpStatus.NO_CONTENT);
    }


}
