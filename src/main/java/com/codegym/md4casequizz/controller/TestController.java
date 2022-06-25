package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.dto.response.ResponMessage;
import com.codegym.md4casequizz.model.*;
import com.codegym.md4casequizz.service.category.ICategoryService;
import com.codegym.md4casequizz.service.level.ILevelService;
import com.codegym.md4casequizz.service.question.IQuestionService;
import com.codegym.md4casequizz.service.result.IResultService;
import com.codegym.md4casequizz.service.test.ITestService;
import com.codegym.md4casequizz.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("tests")
public class TestController {

    @Autowired
    private ITestService testService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private ILevelService levelService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ITypeService typeService;

    @Autowired
    private IResultService resultService;

    @ModelAttribute("question")
    public Iterable<Question> questions() {
        return questionService.findAll();
    }

//
//    @GetMapping("/list")
//    public ModelAndView getAllBlog() {
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blogs", blogService.findAll());
//        return modelAndView;
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<Test>> findAll() {
//        Iterable<Test> blogs = testService.findAll();
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }
//
//@GetMapping("/{id}")
//public ResponseEntity<Test> findTestById(@PathVariable Long id) {
//    Optional<Test> testOptional = testService.findById(id);
//    if (!testOptional.isPresent()) {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    return new ResponseEntity<>(testOptional.get(), HttpStatus.OK);
//}
//
//    @GetMapping("/search/{name}")
//    public ResponseEntity<Iterable<Blog>> findByName(@PathVariable String name) {
//        Iterable<Blog> blogs = blogService.findAllByNameContaining(name);
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody Test test) {
        test.setDate(new Date());
        return new ResponseEntity<>(testService.save(test), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Test>> findAll() {
        Iterable<Test> tests = testService.findAll();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> findById(@PathVariable Long id) {
        Optional<Test> test = testService.findById(id);
        return new ResponseEntity<>(test.get(), HttpStatus.OK);
    }



    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<Test>> findByName(@PathVariable String name) {
        Iterable<Test> tests = testService.findAllByNameContaining(name);
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/{id}/results")
    public ResponseEntity<Iterable<Result>> findResultByTest(@PathVariable Optional<String> id) {
        Optional<Test> testOptional = testService.findById(Long.valueOf(id.get()));
        Iterable<Result> results = resultService.findAllByTest(testOptional.get());
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Test> delete(@PathVariable Long id) {
        Optional<Test> testOptional = testService.findById(id);
        if (!testOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        testService.remove(id);
        return new ResponseEntity<>(testOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTest(@PathVariable Long id, @RequestBody Test test) {
        Optional<Test> testOptional = testService.findById(id);
        if (!testOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        test.setId(testOptional.get().getId());
        test.setDate(new Date());
        testService.save(test);
        return new ResponseEntity<>(new ResponMessage("update success"), HttpStatus.OK);
    }

//
//    @GetMapping("/next3blog/{row}")
//    public ResponseEntity<Iterable<Blog>> getNext3Blog(@PathVariable int row) {
//        Iterable<Blog> blogs = blogService.getNext3Blog(row);
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }
//
//    @GetMapping("/top3")
//    public ResponseEntity<Iterable<Blog>> getTop3() {
//        Iterable<Blog> blogs = blogService.getTop3();
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }
//


}
