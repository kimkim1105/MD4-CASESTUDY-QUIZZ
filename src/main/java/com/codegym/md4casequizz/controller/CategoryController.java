package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.*;
import com.codegym.md4casequizz.security.userprincal.UserDetailService;
import com.codegym.md4casequizz.service.category.ICategoryService;
import com.codegym.md4casequizz.service.question.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
@Autowired
    UserDetailService userDetailService;
    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody Category category) {

        categoryService.save(category);
        return new ResponseEntity<>(new ResponMessage("create success"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Question> questions = (List<Question>) questionService.findAllByCategory(categoryOptional.get());
        if (questions.size() != 0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/questions")
    public ResponseEntity<Iterable<Question>> findQuestionByCategory(@PathVariable Optional<String> id) {
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
    @GetMapping("/list-category")
    public ResponseEntity<?> pageCategory(@PageableDefault(sort = "name",direction = Sort.Direction.ASC)Pageable pageable){
        Page<Category> categories=categoryService.findAll(pageable);
    if (categories.isEmpty())   {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @PostMapping("/create-category")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        User user = userDetailService.getCurrentUser();
        if (!user.getUsername().equals("Anonymous")) {
            if (categoryService.existsByName(category.getName())){
                return new ResponseEntity<>(new ResponMessage("no name category"),HttpStatus.OK);
            }
            categoryService.save(category);
            return new ResponseEntity<>(new ResponMessage("create success"), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new ResponMessage("create failed"), HttpStatus.OK);
    }
}
