package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.model.Result;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.service.result.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/results")
public class ResultController {
    @Autowired
    IResultService resultService;

    @PostMapping
    public ResponseEntity<Result> createTest(@RequestBody Result result) {
        result.setDate(new Date());
        return new ResponseEntity<>(resultService.save(result), HttpStatus.CREATED);
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
