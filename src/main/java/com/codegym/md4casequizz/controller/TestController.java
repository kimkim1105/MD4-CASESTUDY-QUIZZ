package com.codegym.md4casequizz.controller;

import com.codegym.md4casequizz.model.Question;
import com.codegym.md4casequizz.model.Test;
import com.codegym.md4casequizz.service.question.IQuestionService;
import com.codegym.md4casequizz.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("tests")
public class TestController {

    @Autowired
    private ITestService testService;

    @Autowired
    private IQuestionService questionService;


    @ModelAttribute("question")
    public Iterable<Question> questions(){
        return questionService.findAll();
    }

    @PostMapping
    public ResponseEntity<Test> createBlog(@RequestBody Test test) {
        test.setDate(new Date());
        return new ResponseEntity<>(testService.save(test), HttpStatus.CREATED);
    }
//
//    @GetMapping("/list")
//    public ModelAndView getAllBlog() {
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blogs", blogService.findAll());
//        return modelAndView;
//    }
//
    @GetMapping
    public ResponseEntity<Iterable<Test>> findAll() {
        Iterable<Test> blogs = testService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Blog> findById(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
//    }
//
//    @GetMapping("/search/{name}")
//    public ResponseEntity<Iterable<Blog>> findByName(@PathVariable String name) {
//        Iterable<Blog> blogs = blogService.findAllByNameContaining(name);
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }
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
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Blog> delete(@PathVariable Long id) {
//        Optional<Blog> blogOptional = blogService.findById(id);
//        if (!blogOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        blogService.remove(id);
//        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Blog> edit(@RequestBody Blog blog, @PathVariable Long id) {
//        Optional<Blog> blogOptional = blogService.findById(id);
//        if(blog.getImage() != "") {
//            blog.setImage(blogOptional.get().getImage());
//        }
//        blog.setId(id);
//        blog.setDate(blogOptional.get().getDate());
//        blogService.save(blog);
//        return new ResponseEntity<>(blogService.findById(id).get(), HttpStatus.OK);
//    }

}
