package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.*;
import com.codegym.md4casequizz.service.category.ICategoryService;
import com.codegym.md4casequizz.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IQuestionService questionService;

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(new ResponMessage("create success"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}/questions")
    public ResponseEntity<Iterable<Question>> findQuestionByCategory (@PathVariable Optional<String> id) {
        Optional<Category> category = categoryService.findById(Long.valueOf(id.get()));
        Iterable<Question> questions = questionService.findAllByCategory(category.get());
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<Category>> listCategory() {
        Iterable<Category> categories = categoryService.findAll();
        if (categories != null) {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
